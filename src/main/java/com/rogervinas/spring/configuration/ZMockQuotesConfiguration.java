package com.rogervinas.spring.configuration;

import com.rogervinas.spring.domain.Quote;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mock-Z")
public class ZMockQuotesConfiguration {

  @Primary
  @Bean("jonQuote")
  public Quote jonQuote() {
    return () -> "I am a mock.";
  }
}
