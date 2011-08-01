package de.mvitz.examples.guava;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Objects;

public class ObjectsTest {

    @Test
    public void hashcode() throws Exception {
        int hashCode = Objects.hashCode(1, 2);
        assertThat(hashCode, is(Objects.hashCode(1, 2)));
    }

    @Test
    public void equal() throws Exception {
        assertFalse(Objects.equal("String", null));
    }

}
