package de.mvitz.examples.dwr.spring;

public class DefaultGreeting implements Greeting {

    @Override
    public String greet(String name) {
        return "Hello " + name + "!";
    }

}
