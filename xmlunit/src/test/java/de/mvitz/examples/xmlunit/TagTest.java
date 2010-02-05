package de.mvitz.examples.xmlunit;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLNotEqual;

import org.junit.Test;

public class TagTest {

    @Test
    public void testShortcut() throws Exception {
        String expected = "<test><a/><b></b></test>";
        String actual = "<test><a></a><b/></test>";
        assertXMLEqual(expected, actual);
    }

    @Test
    public void testDifferentOrder() throws Exception {
        String expected = "<test><a/><b/></test>";
        String actual = "<test><b/><a/></test>";
        assertXMLEqual(expected, actual);
    }

    @Test
    public void testDifferentOrderDifferentChildrenNumber() throws Exception {
        String expected = "<test><a><b/><b/></a><a><b/></a></test>";
        String actual = "<test><a><b/></a><a><b/><b/></a></test>";
        assertXMLNotEqual(expected, actual);
    }

}
