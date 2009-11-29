package de.mvitz.examples.java.scripting;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.script.Invocable;

import org.junit.Test;

public class JavaScriptTest extends AbstractScriptEngineTest {

    @Override
    String getEngineName() {
        return "JavaScript";
    }

    @Test
    public void scriptFromString() throws Exception {
        String script = "function add(x, y) { return x+y; }; add(x,y);";

        getEngine().put("x", 5);
        getEngine().put("y", 6);
        double result = (Double) getEngine().eval(script);

        assertThat(result, is(11.));
    }

    @Test
    public void scriptFromFile() throws Exception {
        InputStream script = getClass().getClassLoader().getResourceAsStream("javascript.js");

        getEngine().put("i", 5);
        getEngine().put("j", 6);
        double result = (Double) getEngine().eval(new InputStreamReader(script));

        assertThat(result, is(11.));
    }

    @Test
    public void invokeMethod() throws Exception {
        String script = "function add(x, y) { return x + y; }";

        getEngine().eval(script);
        Invocable engine = (Invocable) getEngine();

        double result = (Double) engine.invokeFunction("add", 5, 6);

        assertThat(result, is(11.));
    }

}
