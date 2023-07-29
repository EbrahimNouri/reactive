package com.aroushaco.reactive.repository;

import com.aroushaco.reactive.model.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Long>{
//  Flux<Tutorial> findByTitleContaining(String title);
//
//  Flux<Tutorial> findByPublished(boolean isPublished);
}
