package de.mvitz.examples.java.dsl.sql;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueryTest {

    @Test
    public void queryWithoutConditions() throws Exception {
        final String expected = "SELECT elephant FROM africa";
        final String actual = Query.select("elephant").from("africa").toString();
        assertEquals(expected, actual);
    }

}
