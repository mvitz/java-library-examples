package de.mvitz.examples.guava;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ListTest {

    @Test
    public void transformList() throws Exception {
        List<Double> expected = Lists.newArrayList(1., 2., 3.);

        List<String> stringList = Lists.newArrayList("1", "2", "3");
        List<Double> actual = Lists.transform(stringList, new Function<String, Double>() {

            @Override
            public Double apply(String from) {
                return Double.valueOf(from);
            }
        });

        assertThat(actual, is(expected));
    }

}
