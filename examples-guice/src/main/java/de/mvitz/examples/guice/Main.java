package de.mvitz.examples.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DefaultModule());

        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.greet("John Doe");
    }

    private static class DefaultModule extends AbstractModule {

        @Override
        protected void configure() {
            bind(Greeting.class).to(DefaultGreeting.class);
        }

    }

}
