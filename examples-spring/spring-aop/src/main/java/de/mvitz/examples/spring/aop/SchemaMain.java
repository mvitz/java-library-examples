package de.mvitz.examples.spring.aop;

import de.mvitz.examples.spring.aop.common.Main;
import de.mvitz.examples.spring.aop.common.Manager;

public class SchemaMain {

    public static void main(String[] args) {
        Main main = new Main("spring-aop-schema.xml");
        Manager manager = main.getManager("schemaManager");
        manager.doSomething();
    }

}
