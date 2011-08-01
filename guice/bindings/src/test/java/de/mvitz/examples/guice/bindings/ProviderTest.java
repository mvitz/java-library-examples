package de.mvitz.examples.guice.bindings;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provider;

public class ProviderTest {

    private MyClass sut = Guice.createInjector(new MyModule()).getInstance(MyClass.class);

    @Test
    public void shouldInjectProvidedInstance() throws Exception {
        assertThat(sut.myInterface, is(instanceOf(MyInterfaceImpl.class)));
    }

    private static final class MyClass {
        @Inject MyInterface myInterface;
    }

    private static final class MyInterfaceImplProvider implements Provider<MyInterface> {
        @Override
        public MyInterface get() {
            return new MyInterfaceImpl();
        }
    }

    private static final class MyModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(MyInterface.class).toProvider(MyInterfaceImplProvider.class);
        }
    }

}
