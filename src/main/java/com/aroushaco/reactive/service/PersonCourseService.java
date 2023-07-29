package com.aroushaco.reactive.service;

import com.aroushaco.reactive.model.PersonCourse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonCourseService {
    Flux<PersonCourse> findAll();

    Mono<PersonCourse> findById(Long id);

    Mono<PersonCourse> save(PersonCourse personCourse);

    Mono<PersonCourse> update(Long personId, Long courseId, PersonCourse personCourse);

    Mono<Void> deleteById(Long id);

    Mono<Void> deleteAll();

    Flux<PersonCourse> saveAll(List<PersonCourse> personCourseList);
}
