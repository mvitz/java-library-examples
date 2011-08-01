package de.mvitz.examples.java.reflection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.mvitz.examples.java.reflection.test.AnInterface;

public class ClassForNameTest {

    @Test(expected = ClassNotFoundException.class)
    public void withoutPackage() throws Exception {
        Class.forName("AClass");
    }

    @Test
    public void withPackage() throws Exception {
        Class<?> clazz = Class.forName("de.mvitz.examples.java.reflection.AClass");
        AnInterface instance = (AnInterface) clazz.newInstance();

        String result = instance.doSomething();

        assertEquals("foo", result);
    }

}
