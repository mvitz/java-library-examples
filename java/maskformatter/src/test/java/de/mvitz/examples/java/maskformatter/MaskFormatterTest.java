package de.mvitz.examples.java.maskformatter;

import static org.junit.Assert.assertEquals;

import javax.swing.text.MaskFormatter;

import org.junit.Before;
import org.junit.Test;
/**
 * Taken from http://www.tutego.de/blog/javainsel/2010/04/formatieren-mit-masken-der-maskformatter/
 * 
 * * = jedes Zeichen
 * # = eine Zahl wie sie Character.isDigit() testet
 * ? = Zeichen nach Character.isLetter()
 * A = Zeichen oder Ziffer, also Character.isLetter() oder Character.isDigit()
 * U = Zeichen nach Character.isLetter(), aber konvertiert in Großbuchstaben
 * L = Zeichen nach Character.isLetter(), aber konvertiert in Kleinbuchstaben
 * H = Hexadezimalzeichen (0-9, a-f oder A-F)
 * ‘ = ausmaskierten und nicht interpretierten Bereich
 */
public class MaskFormatterTest {

    private MaskFormatter mf;

    @Before
    public void setUpMaskFormatter() throws Exception {
        mf = new MaskFormatter("####-##-##");
        mf.setValueContainsLiteralCharacters(false);
    }

    @Test
    public void valueToString() throws Exception {
        assertEquals("2010-05-12", mf.valueToString("20100512"));
    }

    @Test
    public void stringToValue() throws Exception {
        assertEquals("20100512", mf.stringToValue("2010-05-12"));
    }
}
