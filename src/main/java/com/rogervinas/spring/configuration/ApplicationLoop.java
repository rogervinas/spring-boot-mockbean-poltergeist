package com.rogervinas.spring.configuration;

import com.rogervinas.spring.domain.Person;
import java.util.Collection;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ApplicationLoop {

  private final Collection<Person> people;

  public ApplicationLoop(Collection<Person> people) {
    this.people = people;
  }

  @Scheduled(fixedDelay = 5000)
  public void run() {
    people.forEach(person -> person.saySomething(System.out));
  }
}
