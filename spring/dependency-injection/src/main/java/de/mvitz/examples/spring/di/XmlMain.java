package de.mvitz.examples.spring.di;

import de.mvitz.examples.spring.di.common.Greeter;
import de.mvitz.examples.spring.di.common.Main;

public class XmlMain {

    public static void main(String[] args) {
        Main main = new Main("spring-di-xml.xml");
        Greeter greeter = main.getGreeter();
        greeter.greet("John Doe");
    }

}
