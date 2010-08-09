package de.mvitz.examples.java.json;

public class Foo {

    private final String foo;

    public Foo(String theFoo) {
        foo = theFoo;
    }

    public String getFoo() {
        return foo;
    }

    @Override
    public String toString() {
        return foo;
    }
}
