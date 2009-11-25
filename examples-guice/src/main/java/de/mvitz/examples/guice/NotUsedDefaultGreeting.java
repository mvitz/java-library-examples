package de.mvitz.examples.guice;

public class NotUsedDefaultGreeting implements Greeting {

    @Override
    public String getGreeting(String name) {
        return "Not used in this example!";
    }

}
