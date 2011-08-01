package de.mvitz.examples.google.guava;

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.compose;
import static com.google.common.base.Predicates.in;
import static com.google.common.base.Predicates.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class PredicateTest {

    @Test
    public void predicates() throws Exception {
        List<String> list1 = Lists.newArrayList("1", "2", "3");
        List<String> list2 = Lists.newArrayList("1", "4", "5");
        List<String> list3 = Lists.newArrayList("1", "4", "6");

        @SuppressWarnings("unchecked")
        boolean result = and(not(in(list1)), in(list2), in(list3)).apply("1");
        assertFalse(result);
    }

    @Test
    public void testCompose() throws Exception {
        List<String> list = Lists.newArrayList("A1", "A2", "A3");
        boolean result = compose(in(list), new Function<String, String>() {

            @Override
            public String apply(String from) {
                return "A" + from;
            }
        }).apply("1");

        assertTrue(result);
    }

}
