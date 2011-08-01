package de.mvitz.examples.guice.bindings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provides;

public class AtProvidesTest {

    private MyClass sut = Guice.createInjector(new MyModule()).getInstance(MyClass.class);

    @Test
    public void shouldInjectProvidedInstance() throws Exception {
        assertThat(sut.myInterface, is(instanceOf(MyInterfaceImpl.class)));
    }

    @Test
    public void shouldInjectProvidedAndAnnotatedInstance() throws Exception {
        assertThat(sut.foo, is("bar"));
    }

    private static final class MyClass {
        @Inject               MyInterface myInterface;
        @Inject @Named("foo") String foo;
    }

    private static final class MyModule extends AbstractModule {
        @Override
        protected void configure() {
        }
        @SuppressWarnings("unused")
        @Provides MyInterface provideMyInterface() { return new MyInterfaceImpl(); }
        @SuppressWarnings("unused")
        @Provides @Named("foo") String provideFoo() { return "bar"; }
    }

}
