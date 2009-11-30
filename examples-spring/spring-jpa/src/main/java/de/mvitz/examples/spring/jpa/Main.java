package de.mvitz.examples.spring.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("jpa-spring.xml");

        Service service = (Service) ctx.getBean("service");

        MyEntity e1 = service.createEntity("test");
        System.out.println("Created entity: " + e1);

        long id = 1;
        MyEntity e2 = service.getEntityForId(id);
        System.out.println("Retrieved entity: " + e2);
    }

}
