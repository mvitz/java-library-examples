package de.mvitz.examples.guice.bindings;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class InjectMemberTest {

    private Injector guice = Guice.createInjector();

    @Test
    public void shouldInjectMembers() throws Exception {
        MyClass clazz = new MyClass();
        assertThat(clazz.myInterface, is(nullValue()));
        
        guice.injectMembers(clazz);
        assertThat(clazz.myInterface, is(notNullValue()));
    }

    private static final class MyClass {
        @Inject MyInterfaceImpl myInterface;
    }

}
