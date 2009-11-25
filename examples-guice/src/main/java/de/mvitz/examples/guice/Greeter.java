package de.mvitz.examples.guice;

import com.google.inject.Inject;

public class Greeter {

    private final Greeting greeting;

    @Inject
    public Greeter(Greeting greeting) {
        this.greeting = greeting;
    }

    public void greet(String name) {
        System.out.println(greeting.getGreeting(name));
    }

}
