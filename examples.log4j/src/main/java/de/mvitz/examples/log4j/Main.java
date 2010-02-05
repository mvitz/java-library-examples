package de.mvitz.examples.log4j;

import org.apache.log4j.Logger;

import de.mvitz.examples.log4j.sub.Sub;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.trace("Main TRACE");
        LOG.debug("Main DEBUG");
        LOG.info("Main INFO");
        LOG.warn("Main WARN");
        LOG.error("Main ERROR");
        LOG.fatal("Main FATAL");
        new Sub().run();
    }

}
