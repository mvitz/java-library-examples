package de.mvitz.examples.spring.aop.common;

public class DefaultManager implements Manager {

    @Override
    public void doSomething() {
        System.out.println("I'm busy doing something!");
    }

}
