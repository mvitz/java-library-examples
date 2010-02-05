package de.mvitz.examples.google.collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class OrderingTest {

    @Test
    public void ordering1() throws Exception {
        Person p1 = new Person("Jane", "Doe");
        Person p2 = new Person("John", "Doe");
        Person p3 = null;

        List<Person> expected = Lists.newArrayList(p1, p2, p3);

        Comparator<Person> lastNameComparator = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };
        Comparator<Person> firstNameComparator = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };
        Ordering<Person> ordering = Ordering.from(lastNameComparator).compound(firstNameComparator)
                .nullsLast();

        List<Person> actual = ordering.sortedCopy(Lists.newArrayList(p2, p3, p1));

        assertThat(actual, is(expected));
    }

    private class Person {

        String firstName;
        String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }

    }
}
