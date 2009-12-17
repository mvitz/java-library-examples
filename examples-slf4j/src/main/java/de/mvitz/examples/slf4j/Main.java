package de.mvitz.examples.slf4j;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.bridge.SLF4JBridgeHandler;

import de.mvitz.examples.slf4j.impl.JclLogging;
import de.mvitz.examples.slf4j.impl.JulLogging;
import de.mvitz.examples.slf4j.impl.Log4jLogging;
import de.mvitz.examples.slf4j.impl.Slf4jLogging;

public class Main {

    private List<Logging> loggers;

    public Main() {
        loggers = new ArrayList<Logging>();
        loggers.add(new JulLogging());
        loggers.add(new JclLogging());
        loggers.add(new Log4jLogging());
        loggers.add(new Slf4jLogging());
    }

    public List<Logging> getLoggers() {
        return loggers;
    }

    public static void main(String[] args) {
        // needed to bridge jul
        SLF4JBridgeHandler.install();

        Main m = new Main();
        for (Logging l : m.getLoggers()) {
            l.log();
        }
    }

}
