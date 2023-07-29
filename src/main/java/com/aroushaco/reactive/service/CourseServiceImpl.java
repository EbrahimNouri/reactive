package com.aroushaco.reactive.service;

import com.aroushaco.reactive.model.Course;
import com.aroushaco.reactive.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Flux<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Mono<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Mono<Course> save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Mono<Course> update(Long id, Course course) {
        return courseRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        course.setCourse_id(id);
                        return courseRepository.save(course);
                    }

                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return courseRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return courseRepository.deleteAll();
    }

    @Override
    public Flux<Course> saveAll(List<Course> courses){
        return courseRepository.saveAll(courses);
    }

}
