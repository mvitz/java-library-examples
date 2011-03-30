package de.mvitz.examples.javaee.service.impl;

import javax.ejb.LocalHome;
import javax.ejb.Stateless;

import de.mvitz.examples.javaee.domain.Name;
import de.mvitz.examples.javaee.service.api.Greeter;

@Stateless
@LocalHome(Greeter.class)
public class SimpleGreeter implements Greeter {

    @Override
    public String greet(Name name) {
        return "Hello " + name + "!";
    }

}
