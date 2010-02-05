package de.mvitz.examples.slf4j.impl;

import java.util.logging.Logger;

import de.mvitz.examples.slf4j.Logging;

public class JulLogging implements Logging {

    private static final Logger LOG = Logger.getLogger(JulLogging.class.getName());

    @Override
    public void log() {
        LOG.info("java.util.logging");
    }

}
