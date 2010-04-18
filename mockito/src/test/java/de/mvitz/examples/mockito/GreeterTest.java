package de.mvitz.examples.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GreeterTest {

    private Greeter greeter;

    @Mock private Greeting greeting;

    @Before
    public void setUp() throws Exception {
        greeter = new Greeter(greeting);
    }

    @Test
    public void testGreeting() throws Exception {
        given(greeting.greet("Test")).willReturn("Hello Test!");
        String result = greeter.greet("Test");
        assertThat(result, is("Hello Test!"));
    }

}
