package de.mvitz.examples.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class GuiceTestModul extends AbstractModule {

    @Override
    protected void configure() {
        bind(Greeting.class).to(DefaultGreeting.class).in(Singleton.class);
        bind(Greeting.class).annotatedWith(Names.named("special")).to(SpecialGreeting.class);
        bind(Greeting.class).annotatedWith(Echo.class).to(EchoGreeting.class);

        bind(String.class).annotatedWith(Names.named("foo")).toInstance("bar");
        bind(String.class).annotatedWith(Names.named("foobar")).toProvider(FooBarProvider.class);
    }

    @Provides @Named("bar")
    protected String providesBar() {
        return "foo";
    }

    private static class FooBarProvider implements Provider<String> {

        @Override
        public String get() {
            return "foobar";
        }
    }

}
