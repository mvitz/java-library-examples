package de.mvitz.examples.java.jaxb;

import java.util.Currency;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CurrencyAdapter extends XmlAdapter<String, Currency> {

    @Override
    public String marshal(Currency theCurrency) throws Exception {
        return theCurrency.toString();
    }

    @Override
    public Currency unmarshal(String theCurrency) throws Exception {
        return Currency.getInstance(theCurrency);
    }
}
