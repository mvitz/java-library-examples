package de.mvitz.examples.spring.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ListPersonRepository implements PersonRepository {

    private static List<Person> persons;

    static {
        persons = new ArrayList<Person>();
        persons.add(new Person(1, "John Doe"));
        persons.add(new Person(2, "Jane Doe"));
    }

    public List<Person> findAll() {
        return persons;
    }

    public Person findById(long id) {
        for (Person p : persons) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new RuntimeException("No person found for id: " + id);
    }

}
