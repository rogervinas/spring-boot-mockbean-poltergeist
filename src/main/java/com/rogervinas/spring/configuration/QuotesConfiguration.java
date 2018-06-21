package com.rogervinas.spring.configuration;

import com.rogervinas.spring.domain.Quote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuotesConfiguration {

  @Bean("jonQuote")
  public Quote jonQuote() {
    return () -> "I know nothing.";
  }

  @Bean("daenerysQuote")
  public Quote daenerysQuote() {
    return () -> "A dragon is not a slave.";
  }
}
