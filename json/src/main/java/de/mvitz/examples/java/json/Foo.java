package de.mvitz.examples.java.json;

public class Foo {

    private String foo;

    /**
     * Needed for Jackson and Gson
     */
    public Foo() {
    }

    public Foo(String theFoo) {
        foo = theFoo;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return foo;
    }

}
