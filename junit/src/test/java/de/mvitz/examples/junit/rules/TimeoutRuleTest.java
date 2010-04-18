package de.mvitz.examples.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.junit.rules.Timeout;

public class TimeoutRuleTest {

    @Rule
    public MethodRule timeout = new Timeout(2000);

    @Test
    public void shouldTimeout() {
        while (true) {
        }
    }

    @Test
    public void shouldNotTimeout() {
    }

}
