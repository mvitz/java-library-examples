package de.mvitz.examples.jaxb;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Currency;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import de.mvitz.examples.java.jaxb.model.Book;
import de.mvitz.examples.java.jaxb.model.Price;

/**
 * From: http://en.newinstance.it/2010/08/05/javabeans-to-xml-with-no-libraries/<br />
 * <br />
 * By: Luigi R. Viggiano
 */
public class JaxbTest {

    private JAXBContext jc;
    private Book book;

    @Before
    public void setUpJaxbContext() throws Exception {
        jc = JAXBContext.newInstance(Book.class);
    }

    @Before
    public void setUpBook() throws Exception {
        book = new Book("Carrie", "Stephen King", new Price(17.25, Currency.getInstance("EUR")));
    }

    @Test
    public void marshallTest() throws Exception {
        String xml = marshall(book);
        assertEquals(expectedXML(), xml);
    }

    @Test
    public void unmarshallTest() throws Exception {
        Book unmarshalledBook = unmarshall();
        assertEquals(book.getAuthor(), unmarshalledBook.getAuthor());
        assertEquals(book.getTitle(), unmarshalledBook.getTitle());
        assertEquals(book.getPrice().getAmount(), unmarshalledBook.getPrice().getAmount(), 0.0);
        assertEquals(book.getPrice().getCurrency(), unmarshalledBook.getPrice().getCurrency());
    }

    private String marshall(Book book) throws JAXBException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(book, out);
        return out.toString();
    }

    private Book unmarshall() throws JAXBException {
        Unmarshaller u = jc.createUnmarshaller();
        return (Book) u.unmarshal(xmlInputStream());
    }

    private InputStream xmlInputStream() {
        return getClass().getClassLoader().getResourceAsStream("book.xml");
    }
    
    private String expectedXML() throws IOException {
        return IOUtils.toString(xmlInputStream(), "UTF-8");
    }
}
