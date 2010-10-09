package de.mvitz.examples.mie;

public final class Address {

    private final String street;
    private final String city;
    private final Country country;

    public Address(String street, String city, Country country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

}
