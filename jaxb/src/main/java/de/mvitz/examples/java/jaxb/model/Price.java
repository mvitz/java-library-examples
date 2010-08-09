package de.mvitz.examples.java.jaxb.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Currency;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.mvitz.examples.java.jaxb.CurrencyAdapter;

@SuppressWarnings("serial")
public class Price implements Serializable {

    private double amount;
    private Currency currency;

    public Price() {
    }

    public Price(double theAmount, Currency theCurrency) {
        amount = theAmount;
        currency = theCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double theAmount) {
        amount = theAmount;
    }

    @XmlJavaTypeAdapter(CurrencyAdapter.class)
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency theCurrency) {
        currency = theCurrency;
    }

    @Override
    public String toString() {
        DecimalFormat fmt = new DecimalFormat("0.00");
        return fmt.format(amount) + currency;
    }
}
