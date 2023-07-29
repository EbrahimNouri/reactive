package com.aroushaco.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

  @Id
  private Long person_id;

  private String name;

}
