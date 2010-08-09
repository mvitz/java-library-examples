package de.mvitz.examples.java.json;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Test;

public class JSONTest {

    @Test
    public void exportTest() throws Exception {
        JSONObject jsonObject = new JSONObject(new Foo("bar"));
        assertEquals(jsonString(), jsonObject.toString());
    }

    @Test
    public void parseTest() throws Exception {
        JSONObject jsonObject = new JSONObject(jsonString());
        String fooAttribute = jsonObject.getString("foo");
        assertEquals("bar", fooAttribute);
    }

    private String jsonString() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("foo.json");
        return IOUtils.toString(in, "UTF-8");
    }
}
