package de.mvitz.examples.mie.util;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import de.mvitz.examples.mie.Address;

public final class AddressMatcher extends TypeSafeMatcher<Address> {

    private final Address address;

    private AddressMatcher(Address address) {
        this.address = address;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("the following address: ")
            .appendValue(address.getStreet())
            .appendText(" ")
            .appendValue(address.getCity())
            .appendText(" ")
            .appendValue(address.getCountry())
        ;
    }

    @Override
    protected boolean matchesSafely(Address a) {
        return address.getStreet().equals(a.getStreet())
            && address.getCity().equals(a.getCity())
            && address.getCountry().equals(a.getCountry())
        ;
    }

    public static Matcher<Address> address(Address address) {
        return new AddressMatcher(address);
    }

}
