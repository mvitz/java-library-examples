package de.mvitz.examples.java.jaxb;

import java.util.Currency;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public final class CurrencyAdapter extends XmlAdapter<String, Currency> {

    @Override
    public String marshal(Currency currency) throws Exception {
        return currency.toString();
    }

    @Override
    public Currency unmarshal(String currency) throws Exception {
        return Currency.getInstance(currency);
    }

}
