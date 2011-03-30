package de.mvitz.examples.javaee.domain;

public final class Name {

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
