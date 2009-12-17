package de.mvitz.examples.slf4j.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.mvitz.examples.slf4j.Logging;

public class Slf4jLogging implements Logging {

    private static final Logger LOG = LoggerFactory.getLogger(Slf4jLogging.class);

    @Override
    public void log() {
        LOG.info("slf4j");
        LOG.info("One argument: '{}'", 1);
        LOG.info("Two arguments: '{}' '{}'", 1, 2);
        LOG.info("Three arguments: '{}' '{}' '{}'", new Object[] { 1, 2, 3 });
    }

}
