package de.mvitz.examples.mie;

import static com.natpryce.makeiteasy.MakeItEasy.an;
import static com.natpryce.makeiteasy.MakeItEasy.make;
import static com.natpryce.makeiteasy.MakeItEasy.with;
import static de.mvitz.examples.mie.Country.NETHERLANDS;
import static de.mvitz.examples.mie.util.AddressMaker.$address;
import static de.mvitz.examples.mie.util.AddressMaker.DEFAULT_CITY;
import static de.mvitz.examples.mie.util.AddressMaker.DEFAULT_COUNTRY;
import static de.mvitz.examples.mie.util.AddressMaker.DEFAULT_STREET;
import static de.mvitz.examples.mie.util.AddressMaker.country;
import static de.mvitz.examples.mie.util.AddressMaker.street;
import static de.mvitz.examples.mie.util.AddressMatcher.address;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class MIETest {

    @Test
    public void defaultAddress() throws Exception {
        Address def = make(an($address));
        assertThat(def, is(address(new Address(DEFAULT_STREET, DEFAULT_CITY, DEFAULT_COUNTRY))));
    }

    @Test
    public void addressWithOneCustomProperty() throws Exception {
        Address def = make(an($address, with(street, "street")));
        assertThat(def, is(address(new Address("street", DEFAULT_CITY, DEFAULT_COUNTRY))));
    }

    @Test
    public void addressWithTwoCustomProperties() throws Exception {
        Address def = make(an($address, with(street, "street"), with(country, NETHERLANDS)));
        assertThat(def, is(address(new Address("street", DEFAULT_CITY, NETHERLANDS))));
    }

}
