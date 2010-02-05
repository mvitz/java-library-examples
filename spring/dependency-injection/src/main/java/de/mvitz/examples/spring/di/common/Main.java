package de.mvitz.examples.spring.di.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private final ApplicationContext ctx;

    public Main(String springConfigFile) {
        ctx = new ClassPathXmlApplicationContext(springConfigFile);
    }

    public Greeter getGreeter() {
        return (Greeter) ctx.getBean("greeter");
    }

}
