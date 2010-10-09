package de.mvitz.examples.mie.util;

import static com.natpryce.makeiteasy.Property.newProperty;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

import de.mvitz.examples.mie.Address;
import de.mvitz.examples.mie.Country;


public class AddressMaker {

    public final static String DEFAULT_STREET = "MyStreet 42";
    public final static String DEFAULT_CITY = "4711 TheCity";
    public final static Country DEFAULT_COUNTRY = Country.GERMANY;

    public final static Property<Address, String> street = newProperty();
    public final static Property<Address, String> city = newProperty();
    public final static Property<Address, Country> country = newProperty();

    public static Instantiator<Address> $address = new Instantiator<Address>() {

        @Override
        public Address instantiate(PropertyLookup<Address> lookup) {
            return new Address(
                    lookup.valueOf(street, DEFAULT_STREET),
                    lookup.valueOf(city, DEFAULT_CITY),
                    lookup.valueOf(country, DEFAULT_COUNTRY)
            );
        }

    };
    
}