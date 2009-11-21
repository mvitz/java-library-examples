package de.mvitz.examples.spring.aop.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private ApplicationContext ctx;

    public Main(String springConfigFile) {
        ctx = new ClassPathXmlApplicationContext(springConfigFile);
    }

    public Manager getManager(String name) {
        return (Manager) ctx.getBean(name);
    }

}
