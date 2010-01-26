package de.mvitz.examples.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Greeter {

    @Inject Greeting defaultGreeting;
    @Inject @Named("special") Greeting specialGreeting;
    @Inject @Echo Greeting echoGreeting;

    Greeting secondDefaultGreeting;
    Greeting secondSpecialGreeting;

    @Inject @Named("foo") String foo;
    final  String bar;
    String foobar;

    @Inject
    public Greeter(@Named("bar") String bar) {
        this.bar = bar;
    }

    @Inject
    protected void injectTheFoobar(@Named("foobar") String foobar) {
        this.foobar = foobar;
    }

    @Inject
    protected void injectSecondGreetings(Greeting defaultGreeting, @Named("special") Greeting specialGreeting) {
        secondDefaultGreeting = defaultGreeting;
        secondSpecialGreeting = specialGreeting;
    }

    public String greetDefault(String name) {
        return defaultGreeting.getGreeting(name);
    }

    public String greetSpecial(String name) {
        return specialGreeting.getGreeting(name);
    }

    public String greetEcho(String name) {
        return echoGreeting.getGreeting(name);
    }

}
