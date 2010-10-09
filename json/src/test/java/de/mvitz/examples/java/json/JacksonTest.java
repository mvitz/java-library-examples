package de.mvitz.examples.java.json;

import static de.mvitz.examples.java.json.FooHelper.fooAttribute;
import static de.mvitz.examples.java.json.FooHelper.fooFromJson;
import static de.mvitz.examples.java.json.FooHelper.fooInstance;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

/**
 * http://wiki.fasterxml.com/JacksonInFiveMinutes
 */
public class JacksonTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void toJson() throws Exception {
        String json = mapper.writeValueAsString(fooInstance());
        assertEquals(fooFromJson(), json);
    }

    @Test
    public void fromJson() throws Exception {
        Foo foo = mapper.readValue(getClass().getResource("/foo.json"), Foo.class);
        assertThat(fooAttribute(), is(foo.getFoo()));
    }

}
