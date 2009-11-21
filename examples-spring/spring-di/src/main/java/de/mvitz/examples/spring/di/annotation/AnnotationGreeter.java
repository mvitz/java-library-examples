package de.mvitz.examples.spring.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.mvitz.examples.spring.di.common.Greeter;
import de.mvitz.examples.spring.di.common.Greeting;

@Component("greeter")
public class AnnotationGreeter extends Greeter {

    @Autowired
    public AnnotationGreeter(Greeting greeting) {
        super(greeting);
    }

}
