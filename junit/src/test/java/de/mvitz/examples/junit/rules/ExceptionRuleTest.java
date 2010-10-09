package de.mvitz.examples.junit.rules;

import static org.hamcrest.Matchers.startsWith;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.mvitz.examples.junit.EnhancedExpectedException;

public class ExceptionRuleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public EnhancedExpectedException eThrown = EnhancedExpectedException.none();

    @Test
    public void shouldThrowNullPointerException() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(startsWith("null"));
        throw new NullPointerException("null not allowed");
    }

    @Test
    public void shouldThrowNamedNullPointerException() throws Exception {
        eThrown.expectNullPointerException("null not allowed");
        throw new NullPointerException("null not allowed");
    }

    @Test
    public void shouldThrowStartingNullPointerExeption() throws Exception {
        eThrown.expectNullPointerException(startsWith("null"));
        throw new NullPointerException("null not allowed");
    }

    @Test
    public void shouldThrowExpectedNullPointerException() throws Exception {
        eThrown.expect(new NullPointerException("null not allowed"));
        throw new NullPointerException("null not allowed");
    }

}
