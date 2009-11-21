package de.mvitz.examples.logback.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sub {

    private final static Logger LOG = LoggerFactory.getLogger(Sub.class);

    public void run() {
        LOG.trace("Sub TRACE");
        LOG.debug("Sub {}", "DEBUG");
        LOG.info("{} {}", new Object[] { "Sub", "INFO" });
        LOG.warn("{} {}", "Sub", "WARN");
        LOG.error("Sub ERROR");
    }

}
