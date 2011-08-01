package de.mvitz.examples.itext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * From: http://blog.codecentric.de/2010/08/pdf-generierung-mit-itext/<br />
 * <br />
 * By: Daniel Reuter<br />
 * http://www.codecentric.de/de/unternehmen/team/solingen/Consultants/DanielReuter/index.html
 */
public class PDFGenerator {

    public static void main(String[] args) throws Exception {
        InputStream pdfTemplate = null;
        PdfReader pdfReader = null;
        PdfStamper stamper = null;

        try {
            pdfTemplate = PDFGenerator.class.getClassLoader().getResourceAsStream(
                    "pdfTemplateExample.pdf");

            pdfReader = new PdfReader(pdfTemplate);

            stamper = new PdfStamper(pdfReader, new FileOutputStream(new File("target/output.pdf")));
            stamper.setFormFlattening(true); // removes formular fields

            stamper.getAcroFields().setField("name", "John Doe");
            stamper.getAcroFields().setField("adress", "Example Street – 123456 Dream Town");
            stamper.getAcroFields().setField("dates", "2008\n2009\n2010\n");
            stamper.getAcroFields().setField("titles", "JAX\nDevoxx\nJavaOne\n");
        } finally {
            if (pdfTemplate != null) {
                pdfTemplate.close();
            }
            if (pdfReader != null) {
                pdfReader.close();
            }
            if (stamper != null) {
                stamper.close();
            }
        }
    }

}
