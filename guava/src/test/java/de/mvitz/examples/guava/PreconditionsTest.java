package de.mvitz.examples.guava;

import static com.google.common.base.Preconditions.checkNotNull;

import org.junit.Test;

public class PreconditionsTest {

    @Test(expected = NullPointerException.class)
    public void notNull() throws Exception {
        String obj = null;
        checkNotNull(obj, "Can't be null!").length();
    }

}
