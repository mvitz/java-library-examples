package de.mvitz.examples.java.jaxb.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Currency;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.mvitz.examples.java.jaxb.CurrencyAdapter;

@SuppressWarnings("serial")
public final class Price implements Serializable {

    private double amount;
    private Currency currency;

    public Price() {
    }

    public Price(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @XmlJavaTypeAdapter(CurrencyAdapter.class)
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return new DecimalFormat("0.00").format(amount) + currency;
    }

}
