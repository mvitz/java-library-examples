package de.mvitz.examples.spring.mvc;

import java.util.List;

public interface PersonRepository {

    List<Person> findAll();

    Person findById(long id);

}
