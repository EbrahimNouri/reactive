package com.aroushaco.reactive;


import com.aroushaco.reactive.model.Course;
import com.aroushaco.reactive.model.Person;
import com.aroushaco.reactive.model.PersonCourse;
import com.aroushaco.reactive.service.CourseService;
import com.aroushaco.reactive.service.PersonCourseService;
import com.aroushaco.reactive.service.PersonService;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Month;
import java.util.*;

@EnableWebFlux
//@EnableR2dbcRepositories
@SpringBootApplication
public class SpringBootR2dbcPostgresqlExampleApplication {

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

        return initializer;
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootR2dbcPostgresqlExampleApplication.class, args);

        PersonService personService = context.getBean(PersonService.class);
        CourseService courseService = context.getBean(CourseService.class);
        PersonCourseService personCourseService = context.getBean(PersonCourseService.class);

        List<String> personNameList = Arrays.asList("John", "ali", "maryam", "kimia");
        List<String> courseNameList = Arrays.asList("math", "chemistry", "physic", "art");

        List<Person> personList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        List<PersonCourse> personCourseList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            personList.add(Person.builder()
                    .name(personNameList.get(i))
                    .build());

            courseList.add(Course.builder()
                    .name(courseNameList.get(i))
                    .build());
        }

        for (long i = 1; i <= courseList.size(); i++) {
            for (long j = 1; j <= personList.size(); j++) {
                if (new Random().nextInt(1, 100) % 2 == 0) {

                    personCourseList.add(new PersonCourse(i, j));
                }
            }
        }

        Flux<Person> personFlux = personService.saveAll(personList);
        Flux<Course> courseFlux = courseService.saveAll(courseList);
        Flux<PersonCourse> personCourseFlux = personCourseService.saveAll(personCourseList);

         Flux.merge(personFlux, courseFlux, personCourseFlux).subscribe();

//        List<Person> listMono = personService.findAll().collectList();

        List<Person> listMono = personFlux.collectList().block();
        System.out.println(listMono);
        Person person = listMono.get(2);
        person.setName("changed");

        Mono<Person> update = personService.update(person);
        Person block = update.block();


        System.out.println(personService.findById(block.getPerson_id()).block());


    }

}



