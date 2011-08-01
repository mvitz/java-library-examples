package de.mvitz.examples.guava;

import static com.google.common.collect.Iterables.getOnlyElement;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class CollectionTest {

    @Test
    public void mapInitialization() throws Exception {
        @SuppressWarnings("unused")
        Map<String, Map<String, Object>> propertiesForID = newHashMap();
    }

    @Test
    public void listInitialization() throws Exception {
        // like Arrays.asList but mutable!
        @SuppressWarnings("unused")
        List<String> names = newArrayList("1", "2", "3");
    }

    @Test
    public void multiMap() throws Exception {
        Multimap<String, String> peopleForLastName = HashMultimap.create();
        peopleForLastName.put("Smith", "Joe");
        peopleForLastName.put("Smith", "Maria");

        Collection<String> smiths = peopleForLastName.get("Smith");
        assertThat(smiths, hasItems("Joe", "Maria"));
    }

    @Test
    public void onlyElementFromList() throws Exception {
        int length = getOnlyElement(newArrayList("Only element")).length();
        assertThat(length, is(12));

        try {
            getOnlyElement(newArrayList("one", "two"));
            fail("Collection contains more than 1 element");
        } catch (IllegalArgumentException ex) {
        }

        try {
            getOnlyElement(newArrayList());
            fail("Collection contains no element");
        } catch (NoSuchElementException ex) {
        }
    }

}
