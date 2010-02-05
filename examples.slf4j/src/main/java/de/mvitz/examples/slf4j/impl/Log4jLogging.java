package de.mvitz.examples.slf4j.impl;

import org.apache.log4j.Logger;

import de.mvitz.examples.slf4j.Logging;

public class Log4jLogging implements Logging {

    private static final Logger LOG = Logger.getLogger(Log4jLogging.class);

    @Override
    public void log() {
        LOG.info("apache.log4j");
    }

}
