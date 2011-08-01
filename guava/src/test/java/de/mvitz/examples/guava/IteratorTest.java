package de.mvitz.examples.guava;

import static com.google.common.base.Predicates.notNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class IteratorTest {

    @Test
    public void filterList() throws Exception {
        List<String> expected = Lists.newArrayList("B100", null, "B200");

        List<String> list = Lists.newArrayList("A100", "B100", null, "B200");
        Iterable<String> filtered = Iterables.filter(list, new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return input == null || input.startsWith("B");
            }
        });
        List<String> actual = Lists.newArrayList(filtered);

        assertThat(actual, is(expected));
    }

    @Test
    public void filterIsNull() throws Exception {
        List<String> expected = Lists.newArrayList("1", "3");

        List<String> list = Lists.newArrayList("1", null, "3");
        Iterable<String> filtered = Iterables.filter(list, notNull());
        List<String> actual = Lists.newArrayList(filtered);

        assertThat(actual, is(expected));
    }

}
