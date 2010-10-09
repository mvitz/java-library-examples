package de.mvitz.examples.java.json;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

public final class FooHelper {

    private FooHelper() {
    }

    public static Foo fooInstance() {
        return new Foo(fooAttribute());
    }

    public static String fooFromJson() throws IOException {
        return IOUtils.toString(FooHelper.class.getResourceAsStream("/foo.json"), "UTF-8");
    }

    public static String fooAttribute() {
        return "bar";
    }

}
