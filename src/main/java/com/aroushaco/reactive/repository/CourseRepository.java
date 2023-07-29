package com.aroushaco.reactive.repository;

import com.aroushaco.reactive.model.Course;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends R2dbcRepository<Course, Long>{
//  Flux<Tutorial> findByTitleContaining(String title);
//
//  Flux<Tutorial> findByPublished(boolean isPublished);
}
