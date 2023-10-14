package com.aroushaco.reactive.repository;

import com.aroushaco.reactive.model.PersonCourse;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonCourseRepository extends R2dbcRepository<PersonCourse, Long>{

    Flux<PersonCourse> findPersonCourseByCourseId(Long courseId);
}
