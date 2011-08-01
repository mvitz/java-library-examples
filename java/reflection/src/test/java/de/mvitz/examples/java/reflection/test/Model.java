package de.mvitz.examples.java.reflection.test;

public final class Model {

    private String name;

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model[" + name + "]";
    }

}
