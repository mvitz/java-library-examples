package de.mvitz.examples.jsf.helloworld;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorldBean {

    private String name;
    private String output;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}
