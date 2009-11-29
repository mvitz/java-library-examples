package de.mvitz.examples.aspectj;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UserRepositoryTest {

    @Test
    public void findAll() throws Exception {
        User john = new User("John Doe");
        User jane = new User("Jane Doe");

        List<User> expected = Arrays.asList(john, jane);

        john.save();
        jane.save();

        assertThat(User.findAll(), is(expected));
    }

}
