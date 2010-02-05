package de.mvitz.examples.guice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceTest {

    private static final Injector injector = Guice.createInjector(new GuiceTestModul());

    private Greeter greeter;

    @Before
    public void setUp() throws Exception {
        greeter = injector.getInstance(Greeter.class);
    }

    @Test
    public void testDefaultInjection() throws Exception {
        String greeting = greeter.greetDefault("Michael");
        assertEquals("Hello Michael!", greeting);
    }

    @Test
    public void testInjectionFromAtNamed() throws Exception {
        String greeting = greeter.greetSpecial("Michael");
        assertEquals("Hello Michael from Guice!", greeting);
    }

    @Test
    public void testScopes() throws Exception {
        assertSame(greeter.defaultGreeting, greeter.secondDefaultGreeting);
        assertNotSame(greeter.specialGreeting, greeter.secondSpecialGreeting);
    }

    @Test
    public void testAnnotatedInjection() throws Exception {
        String greeting = greeter.greetEcho("Michael");
        assertEquals("Michael", greeting);
    }

    @Test
    public void testInstanceBindings() throws Exception {
        String foo = greeter.foo;
        assertEquals("bar", foo);
    }

    @Test
    public void testAtProvides() throws Exception {
        String bar = greeter.bar;
        assertEquals("foo", bar);
    }

    @Test
    public void testProvider() throws Exception {
        String foobar = greeter.foobar;
        assertEquals("foobar", foobar);
    }

}
