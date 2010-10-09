package de.mvitz.examples.java.json;

import static de.mvitz.examples.java.json.FooHelper.fooAttribute;
import static de.mvitz.examples.java.json.FooHelper.fooInstance;
import static de.mvitz.examples.java.json.FooHelper.fooFromJson;
import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

public class JSONTest {

    @Test
    public void toJson() throws Exception {
        JSONObject jsonObject = new JSONObject(fooInstance());
        assertEquals(fooFromJson(), jsonObject.toString());
    }

    @Test
    public void fromJson() throws Exception {
        JSONObject jsonObject = new JSONObject(fooFromJson());
        String fooAttribute = jsonObject.getString("foo");
        assertEquals(fooAttribute(), fooAttribute);
    }

}
