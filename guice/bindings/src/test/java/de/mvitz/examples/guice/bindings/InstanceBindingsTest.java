package de.mvitz.examples.guice.bindings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.name.Names;

public class InstanceBindingsTest {

    private MyClass sut = Guice.createInjector(new MyModule()).getInstance(MyClass.class);

    @Test
    public void shouldInjectInstance() throws Exception {
        assertThat(sut.foo, is("bar"));
    }

    private static final class MyClass {
        @Inject @Named("foo") String foo;
    }

    private static final class MyModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(String.class).annotatedWith(Names.named("foo")).toInstance("bar");
        }
    }

}
