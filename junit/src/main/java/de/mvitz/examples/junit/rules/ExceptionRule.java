package de.mvitz.examples.junit.rules;

import static org.hamcrest.Matchers.startsWith;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionRule {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(startsWith("null"));
        throw new NullPointerException("null not allowed");
    }

}
