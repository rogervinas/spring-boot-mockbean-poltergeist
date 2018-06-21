package com.rogervinas.spring;

import com.rogervinas.spring.domain.Person;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Mock
	private PrintStream out;

	@Autowired
	@Qualifier("jon")
	private Person jon;

	@Autowired
	@Qualifier("daenerys")
	private Person daenerys;

	@Test
	public void jon_should_say_his_quote() {
		jon.saySomething(out);
		verify(out, times(1)).println(eq("Jon Snow > I know nothing."));
	}

	@Test
	public void daenerys_should_say_her_quote() {
		daenerys.saySomething(out);
		verify(out, times(1)).println(eq("Daenerys Targaryen > A dragon is not a slave."));
	}
}
