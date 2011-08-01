package de.mvitz.examples.guice.scopes;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceScopesTest {

    @Test
    public void shouldInjectSameSingleton() throws Exception {
        Injector injector = Guice.createInjector();

        AClass a = injector.getInstance(AClass.class);
        AnotherClass another = injector.getInstance(AnotherClass.class);

        assertThat(a.singleton, is(another.singleton));
    }

    @Test
    public void shouldInjectDifferentPrototype() throws Exception {
        Injector injector = Guice.createInjector();

        AClass a = injector.getInstance(AClass.class);
        AnotherClass another = injector.getInstance(AnotherClass.class);

        assertThat(a.prototype, is(not(another.prototype)));
    }

    @Singleton static final class MySingleton {}
               static final class MyPrototype {}

    static final class AClass {
        @Inject MySingleton singleton;
        @Inject MyPrototype prototype;
    }

    static final class AnotherClass {
        @Inject MySingleton singleton;
        @Inject MyPrototype prototype;
    }

}
