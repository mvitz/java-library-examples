package de.mvitz.examples.log4j.sub;

import org.apache.log4j.Logger;

public class Sub {

    private static final Logger LOG = Logger.getLogger(Sub.class);

    public void run() {
        LOG.trace("Sub TRACE");
        LOG.debug("Sub DEBUG");
        LOG.info("Sub INFO");
        LOG.warn("Sub WARN");
        LOG.error("Sub ERROR");
        LOG.fatal("Sub FATAL");
    }

}
