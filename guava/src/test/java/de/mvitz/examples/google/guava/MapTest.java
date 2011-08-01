package de.mvitz.examples.google.guava;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

public class MapTest {

    @Test
    public void biMap() throws Exception {
        Map<Integer, String> expected = new HashMap<Integer, String>();
        expected.put(5, "Another five");
        expected.put(1, "One");

        BiMap<Integer, String> actual = HashBiMap.create();
        actual.put(5, "Five");
        actual.put(1, "One");
        actual.put(5, "Another five");

        assertThat(actual, is(expected));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutableMap() throws Exception {
        ImmutableMap<String, Integer> map = new ImmutableMap.Builder<String, Integer>()
            .put("One", 1)
            .build();
        map.put("Two", 2);
    }

    @Test
    public void difference() throws Exception {
        Map<String, Integer> inCommon = Maps.newHashMap();
        inCommon.put("Two", 2);

        Map<String, Integer> onlyIn1 = Maps.newHashMap();
        onlyIn1.put("One", 1);

        Map<String, Integer> map1 = Maps.newHashMap();
        map1.put("One", 1);
        map1.put("Two", 2);

        Map<String, Integer> map2 = Maps.newHashMap();
        map2.put("Two", 2);
        map2.put("Three", 3);

        MapDifference<String, Integer> difference = Maps.difference(map1, map2);

        assertFalse(difference.areEqual());
        assertThat(difference.entriesInCommon(), is(inCommon));
        assertThat(difference.entriesOnlyOnLeft(), is(onlyIn1));
    }

}
