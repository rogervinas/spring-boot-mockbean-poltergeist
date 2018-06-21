package com.rogervinas.spring.domain;

import java.io.PrintStream;

public class Person {

  private final String name;
  private final Quote quote;

  public Person(String name, Quote quote) {
    this.name = name;
    this.quote = quote;
  }

  public void saySomething(PrintStream out) {
    out.println(name + " > " + quote.text());
  }
}
