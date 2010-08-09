package de.mvitz.examples.java.jaxb.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class Book implements Serializable {

    private String title;
    private String author;
    private Price price;

    public Book() {
    }

    public Book(String theTitle, String theAuthor, Price thePrice) {
        title = theTitle;
        author = theAuthor;
        price = thePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String theTitle) {
        title = theTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String theAuthor) {
        author = theAuthor;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price thePrice) {
        price = thePrice;
    }

    @Override
    public String toString() {
        return title + " by " + author + ", " + price;
    }

}
