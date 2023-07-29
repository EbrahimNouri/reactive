package com.aroushaco.reactive.repository;

import com.aroushaco.reactive.model.PersonCourse;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCourseRepository extends R2dbcRepository<PersonCourse, Long>{
//  Flux<Tutorial> findByTitleContaining(String title);
//
//  Flux<Tutorial> findByPublished(boolean isPublished);
}
