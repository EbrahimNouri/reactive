package com.aroushaco.reactive.service;

import com.aroushaco.reactive.model.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CourseService {
    Flux<Course> findAll();

    Mono<Course> findById(Long id);

    Mono<Course> save(Course course);

    Mono<Course> update(Long id, Course course);

    Mono<Void> deleteById(Long id);

    Mono<Void> deleteAll();

    Flux<Course> saveAll(List<Course> courses);
}
