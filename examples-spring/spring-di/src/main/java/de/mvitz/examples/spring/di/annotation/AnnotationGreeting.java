package de.mvitz.examples.spring.di.annotation;

import org.springframework.stereotype.Component;

import de.mvitz.examples.spring.di.common.Greeting;

@Component
public class AnnotationGreeting implements Greeting {

    private static final String GREETING = "Hello %s from Annotation!";

    @Override
    public String getGreeting(String name) {
        return String.format(GREETING, name);
    }

}
