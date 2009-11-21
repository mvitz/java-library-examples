package de.mvitz.examples.spring.aop;

import de.mvitz.examples.spring.aop.common.Main;
import de.mvitz.examples.spring.aop.common.Manager;

// using the spring aop api you can remove aspectj runtime as dependency
public class ApiMain {

    public static void main(String[] args) {
        Main main = new Main("spring-aop-api.xml");
        Manager manager = main.getManager("apiManager");
        manager.doSomething();
    }

}
