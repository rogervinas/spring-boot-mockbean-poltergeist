package com.rogervinas.spring.configuration;

import com.rogervinas.spring.domain.Person;
import com.rogervinas.spring.domain.Quote;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PeopleConfiguration {

  @Bean("jon")
  public Person jon(@Qualifier("jonQuote") Quote quote) {
    return new Person("Jon Snow", quote);
  }

  @Bean("daenerys")
  public Person daenerys(@Qualifier("daenerysQuote") Quote quote) {
    return new Person("Daenerys Targaryen", quote);
  }
}
