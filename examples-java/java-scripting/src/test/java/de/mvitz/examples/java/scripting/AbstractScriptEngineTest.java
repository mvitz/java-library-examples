package de.mvitz.examples.java.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Before;

public abstract class AbstractScriptEngineTest {

    private ScriptEngine engine;

    @Before
    public void setUpScriptEngine() throws Exception {
        engine = new ScriptEngineManager().getEngineByName(getEngineName());
    }

    public ScriptEngine getEngine() {
        return engine;
    }

    abstract String getEngineName();

}
