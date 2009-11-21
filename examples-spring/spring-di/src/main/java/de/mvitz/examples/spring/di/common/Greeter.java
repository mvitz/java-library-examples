package de.mvitz.examples.spring.di.common;

public class Greeter {

    private final Greeting greeting;

    public Greeter(Greeting greeting) {
        this.greeting = greeting;
    }

    public void greet(String name) {
        System.out.println(greeting.getGreeting(name));
    }

}
