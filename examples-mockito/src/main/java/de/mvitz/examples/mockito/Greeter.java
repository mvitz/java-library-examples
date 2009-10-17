package de.mvitz.examples.mockito;

public class Greeter {

    private final Greeting greeting;

    public Greeter(final Greeting greeting) {
        this.greeting = greeting;
    }

    public String greet(String name) {
        return greeting.greet(name);
    }

}
