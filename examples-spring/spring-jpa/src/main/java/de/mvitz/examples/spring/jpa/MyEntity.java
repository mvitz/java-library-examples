package de.mvitz.examples.spring.jpa;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String value;

    public MyEntity() {
    }

    public MyEntity(final String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, value);
    }

}
