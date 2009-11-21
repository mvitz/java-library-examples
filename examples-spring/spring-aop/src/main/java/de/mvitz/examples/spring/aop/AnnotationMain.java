package de.mvitz.examples.spring.aop;

import de.mvitz.examples.spring.aop.common.Main;
import de.mvitz.examples.spring.aop.common.Manager;

public class AnnotationMain {

    public static void main(String[] args) {
        Main main = new Main("spring-aop-annotation.xml");
        Manager manager = main.getManager("annotationManager");
        manager.doSomething();
    }

}
