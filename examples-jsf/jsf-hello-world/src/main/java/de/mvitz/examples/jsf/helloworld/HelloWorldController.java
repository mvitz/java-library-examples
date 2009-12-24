package de.mvitz.examples.jsf.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class HelloWorldController {

    @ManagedProperty(value = "#{helloWorldBean}")
    private HelloWorldBean helloWorldBean;

    public void setHelloWorldBean(HelloWorldBean helloWorldBean) {
        this.helloWorldBean = helloWorldBean;
    }

    public String greet() {
        createGreeting();
        return "greeting";
    }

    public String ajaxGreet() {
        createGreeting();
        return null;
    }

    public void createGreeting() {
        String name = helloWorldBean.getName();
        String greeting = "Hello " + name + "!";
        helloWorldBean.setOutput(greeting);
    }

}
