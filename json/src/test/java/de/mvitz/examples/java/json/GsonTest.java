package de.mvitz.examples.java.json;

import static de.mvitz.examples.java.json.FooHelper.fooAttribute;
import static de.mvitz.examples.java.json.FooHelper.fooFromJson;
import static de.mvitz.examples.java.json.FooHelper.fooInstance;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;

/**
 * http://sites.google.com/site/gson/gson-user-guide
 */
public class GsonTest {

    private final Gson gson = new Gson();

    @Test
    public void toJson() throws Exception {
        String json = gson.toJson(fooInstance());
        assertEquals(fooFromJson(), json);
    }

    @Test
    public void parse() throws Exception {
        Foo foo = gson.fromJson(fooFromJson(), Foo.class);
        assertEquals(fooAttribute(), foo.getFoo());
    }

}
