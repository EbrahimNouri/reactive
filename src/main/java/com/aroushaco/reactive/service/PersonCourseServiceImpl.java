package com.aroushaco.reactive.service;

import com.aroushaco.reactive.exception.PersonCourseException;
import com.aroushaco.reactive.model.Course;
import com.aroushaco.reactive.model.PersonCourse;
import com.aroushaco.reactive.repository.PersonCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonCourseServiceImpl implements PersonCourseService {

    @Autowired
    private PersonCourseRepository personCourseRepository;
    @Autowired
    private CourseService courseService;

    @Override
    public Flux<PersonCourse> findAll() {
        return personCourseRepository.findAll();
    }

    @Override
    public Mono<PersonCourse> findById(Long id) {
        return personCourseRepository.findById(id);
    }

    @Override
    public Mono<PersonCourse> save(PersonCourse personCourse) {

        return checkRegister(personCourse).flatMap(optionalTutorial -> {
            if (optionalTutorial)
                throw  new PersonCourseException("person course already exists or course capacity is full");

            return personCourseRepository.save(personCourse);

        });
    }

    @Override
    public Mono<PersonCourse> update(Long personId, Long courseId, PersonCourse personCourse) {
        return personCourseRepository.findById(personId).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        personCourse.setCourseId(courseId);
                        personCourse.setPersonId(personId);
                        return personCourseRepository.save(personCourse);
                    }

                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return personCourseRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return personCourseRepository.deleteAll();
    }

    @Override
    public Flux<PersonCourse> saveAll(List<PersonCourse> personCourseList) {
        return personCourseRepository.saveAll(personCourseList);
    }

    public Mono<Boolean> checkRegister(PersonCourse personCourse) {
        Long courseId = personCourse.getCourseId();
        Long personId = personCourse.getPersonId();

        Mono<Long> capacityMono = courseService.findById(courseId)
                .map(Course::getCapacity);

        Flux<PersonCourse> personCourseFlux = personCourseRepository.findPersonCourseByCourseId(courseId);

        Mono<Boolean> listMonoMono = personCourseFlux.count()
                .flatMap(count -> capacityMono.map(capacity ->
                        count >= capacity));

        Mono<Boolean> bMono = personCourseFlux
                .any(pc -> pc.getPersonId().equals(personId));

        return Mono.zip(listMonoMono, bMono, (listMono, b) -> listMono | b);
    }

}
