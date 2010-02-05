package de.mvitz.examples.guice;

public class SpecialGreeting implements Greeting {

    private static final String GREETING = "Hello %s from Guice!";

    @Override
    public String getGreeting(String name) {
        return String.format(GREETING, name);
    }

}
