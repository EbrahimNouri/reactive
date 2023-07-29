package com.aroushaco.reactive.controller;

import com.aroushaco.reactive.model.Person;
import com.aroushaco.reactive.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {
  @Autowired
  private PersonService personService;

  @GetMapping("/person/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Person> getTutorialById(@PathVariable("id") Long id) {
    return personService.findById(id);
  }

  @PostMapping("/person")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Person> createTutorial(@RequestBody Person person) {
    System.out.println(person);
    return personService.save(new Person( person.getPerson_id(), person.getName()));
  }

  @GetMapping("/person")
  public Flux<Person> findAll(){
    return personService.findAll();
  }

  @PutMapping("/person/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Person> updateTutorial( @RequestBody Person person) {
    return personService.update( person);
  }

  @DeleteMapping("/person/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteTutorial(@PathVariable("id") Long id) {
    return personService.deleteById(id);
  }

  @DeleteMapping("/persons")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteAllTutorials() {
    return personService.deleteAll();
  }

}
