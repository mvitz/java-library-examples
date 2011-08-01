package de.mvitz.examples.java.reflection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import de.mvitz.examples.java.reflection.test.Model;

public class PropertyChangerTest {

    @Test
    public void test() throws Exception {
        // given
        final List<Model> models = Arrays.asList(new Model("A"), new Model("B"));
        // when
        new PropertyChanger<Model>(Model.class).changePropertyForEvery(models, "name", "C");
        // then
        assertThat(models.get(0).getName(), is("C"));
        assertThat(models.get(1).getName(), is("C"));
    }

}
