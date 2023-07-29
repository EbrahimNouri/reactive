package com.aroushaco.reactive.service;

import com.aroushaco.reactive.model.Person;
import com.aroushaco.reactive.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

  @Autowired
  PersonRepository personRepository;

  @Override
  public Flux<Person> findAll() {
    return personRepository.findAll();
  }

  @Override
  public Mono<Person> findById(Long id) {
    return personRepository.findById(id);
  }

  @Override
  public Mono<Person> save(Person person) {
    return personRepository.save(person);
  }

  @Override
  public Flux<Person> saveAll(List<Person> person){
    return personRepository.saveAll(person);
  }

  @Override
  public Mono<Person> update( Person person) {
    return personRepository.findById(person.getPerson_id()).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(optionalTutorial -> {
          if (optionalTutorial.isPresent()) {
            person.setPerson_id(person.getPerson_id());
            return personRepository.save(person);
          }

          return Mono.empty();
        });
  }

  @Override
  public Mono<Void> deleteById(Long id) {
    return personRepository.deleteById(id);
  }

  @Override
  public Mono<Void> deleteAll() {
    return personRepository.deleteAll();
  }

}
