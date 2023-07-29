package com.aroushaco.reactive.service;

import com.aroushaco.reactive.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonService {
    Flux<Person> findAll();

    Mono<Person> findById(Long id);

    Mono<Person> save(Person person);

    Flux<Person> saveAll(List<Person> person);

    Mono<Person> update( Person person);

    Mono<Void> deleteById(Long id);

    Mono<Void> deleteAll();
}
