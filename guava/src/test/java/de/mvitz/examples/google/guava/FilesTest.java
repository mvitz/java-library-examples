package de.mvitz.examples.google.guava;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class FilesTest {

    @Test
    public void readLines() throws Exception {
        File f = new File(getClass().getResource("/test.txt").toURI());
        List<String> lines = Files.readLines(f, Charsets.UTF_8);
        Assert.assertThat(lines.size(), Matchers.is(2));
        Assert.assertThat(lines, Matchers.hasItems("Line 1", "Line 2"));
    }
}
