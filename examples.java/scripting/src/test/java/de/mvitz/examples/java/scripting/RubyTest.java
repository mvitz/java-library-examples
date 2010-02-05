package de.mvitz.examples.java.scripting;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.script.Invocable;

import org.junit.Test;

public class RubyTest extends AbstractScriptEngineTest {

    @Override
    String getEngineName() {
        return "ruby";
    }

    @Test
    public void scriptFromString() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("ruby.rb");

        getEngine().eval(new InputStreamReader(in));
        Invocable engine = (Invocable) getEngine();

        long result = (Long) engine.invokeFunction("add", 5, 6);

        assertThat(result, is(11l));
    }

}
