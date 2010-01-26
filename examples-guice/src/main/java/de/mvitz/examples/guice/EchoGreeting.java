package de.mvitz.examples.guice;

public class EchoGreeting implements Greeting {

    @Override
    public String getGreeting(String name) {
        return name;
    }

}
