package de.mvitz.examples.guava;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class JoinerTest {

    @Test
    public void join() throws Exception {
        String expected = "1 | 2 | 3";

        List<String> list = Lists.newArrayList("1", "2", "3");

        String actual = Joiner.on(" | ").join(list);

        assertThat(actual, is(expected));
    }

    @Test
    public void useForNull() throws Exception {
        String expected = "1 | 2 | 3";

        List<String> list = Lists.newArrayList("1", null, "3");

        String actual = Joiner.on(" | ").useForNull("2").join(list);

        assertThat(actual, is(expected));
    }

}
