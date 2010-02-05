package de.mvitz.examples.spring.di.xml;

import de.mvitz.examples.spring.di.common.Greeting;

public class XmlGreeting implements Greeting {

    private static final String GREETING = "Hello %s from XML!";

    @Override
    public String getGreeting(String name) {
        return String.format(GREETING, name);
    }

}
