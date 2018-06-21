package com.rogervinas.spring;

import com.rogervinas.spring.domain.Person;
import com.rogervinas.spring.domain.Quote;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"mock-A", "mock-Z"})
public class MockQuoteTestWithMockBean {

  @Mock
  private PrintStream out;

  @MockBean(name = "jonQuote")
  private Quote jonQuote;

  @Autowired
  @Qualifier("jon")
  private Person jon;

  @Test
  public void jon_should_say_whatever_i_want_him_to() {
    when(jonQuote.text()).thenReturn("I am dumb.");
    jon.saySomething(out);
    verify(out, times(1)).println(eq("Jon Snow > I am dumb."));
  }
}
