package de.mvitz.examples.guice.bindings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class LinkedBindingsTest {

    private Injector guice = Guice.createInjector(new MyModule());

    @Test
    public void shouldMapInterfaceToImplementation() throws Exception {
        assertThat(guice.getInstance(MyInterface.class), is(instanceOf(MyInterfaceImpl.class)));
    }

    @Test
    public void shouldMapChainedInterfaceToImplementation() throws Exception {
        assertThat(guice.getInstance(MySuperInterface.class), is(instanceOf(MyInterfaceImpl.class)));
    }

    private static final class MyModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(MySuperInterface.class).to(MyInterface.class);
            bind(MyInterface.class).to(MyInterfaceImpl.class);
        }
    }

}
