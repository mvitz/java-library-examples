package de.mvitz.examples.argsj4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class Options {

    @Option(name = "-foo", required = true, usage = "Foo")
    private String foo;

    @Option(name = "-bool", usage = "A boolean value")
    private boolean bool;

    @Option(name = "-file", usage = "A file")
    private File file;

    @Argument(index = 1)
    private List<String> list = new ArrayList<String>();

    @Argument(index = 0)
    private String firstArgument;

    public String getFoo() {
        return foo;
    }

    public boolean isBool() {
        return bool;
    }

    public File getFile() {
        return file;
    }

    public List<String> getList() {
        return list;
    }

    public String getFirstArgument() {
        return firstArgument;
    }

}
