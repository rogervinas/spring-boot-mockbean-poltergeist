package com.rogervinas.spring;

import com.rogervinas.spring.domain.Person;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mock-A")
public class MockQuoteTestWithConfigurationA {

  @Mock
  private PrintStream out;

  @Autowired
  @Qualifier("jon")
  private Person jon;

  /*
    This test would fail because QuotesConfiguration overrides AMockQuotesConfiguration because is processed after.
    You should see a log trace: DefaultListableBeanFactory: Overriding bean definition for bean 'jonQuote' with a different definition ...
    @Primary annotation is not applied in this case.
  */

  @Test
  public void jon_should_say_whatever_i_want_him_to() {
    jon.saySomething(out);
    verify(out, times(1)).println(eq("Jon Snow > I am a mock."));
  }
}
