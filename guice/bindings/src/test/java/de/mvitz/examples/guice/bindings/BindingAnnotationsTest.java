package de.mvitz.examples.guice.bindings;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.BindingAnnotation;
import com.google.inject.Guice;
import com.google.inject.name.Names;

public class BindingAnnotationsTest {

    private MyClass sut = Guice.createInjector(new MyModule()).getInstance(MyClass.class);

    @Test
    public void shouldInjectImplementationForNormalBinding() throws Exception {
        assertThat(sut.bar, is(instanceOf(MyInterfaceImpl.class)));
    }

    @Test
    public void shouldInjectFooImplForAnnotatedBinding() throws Exception {
        assertThat(sut.foo, is(instanceOf(FooImpl.class)));
    }

    @Test
    public void shouldInjectNamedImplForNamedBinding() throws Exception {
        assertThat(sut.named, is(instanceOf(NamedImpl.class)));
    }

    private static final class MyClass {
        @Inject                MyInterface bar;
        @Inject @Foo           MyInterface foo;
        @Inject @Named("blub") MyInterface named;
    }

    private static final class MyModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(MyInterface.class).to(MyInterfaceImpl.class);
            bind(MyInterface.class).annotatedWith(Foo.class).to(FooImpl.class);
            bind(MyInterface.class).annotatedWith(Names.named("blub")).to(NamedImpl.class);
        }
    }

    private static final class FooImpl implements MyInterface {}

    private static final class NamedImpl implements MyInterface {}

    @BindingAnnotation @Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
    private static @interface Foo {}

}
