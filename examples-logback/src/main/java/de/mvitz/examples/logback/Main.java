package de.mvitz.examples.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.mvitz.examples.logback.sub.Sub;

public class Main {

    private final static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.trace("Main TRACE");
        LOG.debug("Main {}", "DEBUG");
        LOG.info("{} {}", new Object[] { "Main", "INFO" });
        LOG.warn("{} {}", "Main", "WARN");
        LOG.error("Main ERROR");
        new Sub().run();
    }

}
