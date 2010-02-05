package de.mvitz.examples.slf4j.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.mvitz.examples.slf4j.Logging;

public class JclLogging implements Logging {

    private static final Log LOG = LogFactory.getLog(JclLogging.class);

    @Override
    public void log() {
        LOG.info("apache.commons.logging");
    }

}
