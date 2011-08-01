package de.mvitz.examples.args4j;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import de.mvitz.examples.argsj4.Options;

public class OptionsTest {

    private CmdLineParser parser;
    private Options options;

    @Before
    public void setUp() throws Exception {
        options = new Options();
        parser = new CmdLineParser(options);
    }

    @Test
    public void bindingAStringValue() throws Exception {
        parser.parseArgument("-foo", "bar");
        assertEquals("bar", options.getFoo());
    }

    @Test(expected = CmdLineException.class)
    public void notBindingAnRequiredValueShouldThrowException() throws Exception {
        parser.parseArgument();
    }

    @Test
    public void notBindingAnBooleanValue() throws Exception {
        parser.parseArgument("-foo", "bar");
        assertEquals(false, options.isBool());
    }

    @Test
    public void bindingAnBooleanValue() throws Exception {
        parser.parseArgument("-foo", "bar", "-bool");
        assertEquals(true, options.isBool());
    }

    @Test
    public void printUsage() throws Exception {
        // TODO: do assert
        parser.printUsage(System.out);
    }

    @Test
    public void bindingAllArguments() throws Exception {
        parser.parseArgument("-foo", "bar", "test", "test2", "test3");
        assertEquals("test", options.getFirstArgument());
        assertEquals(Arrays.asList("test2", "test3"), options.getList());
    }

    @Test
    public void bindingAFileValue() throws Exception {
        parser.parseArgument("-foo", "bar", "-file", "file");
        assertEquals(new File("file"), options.getFile());
    }

}
