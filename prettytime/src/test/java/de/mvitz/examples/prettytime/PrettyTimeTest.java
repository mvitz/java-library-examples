package de.mvitz.examples.prettytime;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.ocpsoft.pretty.time.PrettyTime;

/**
 * Taken from: http://www.tutego.de/blog/javainsel/2010/04/programmbibliothek-fr-gesprochene-dauern-prettytime
 * 
 * @author mvitz
 * 
 */
public class PrettyTimeTest {

    private PrettyTime p;

    @Before
    public void setUpPrettyTime() {
        p = new PrettyTime(new Date(0), new Locale("en"));
    }

    @Test
    public void momentsFromNow() throws Exception {
        shouldBe(0, "moments from now");
    }

    @Test
    public void hoursFromNow() throws Exception {
        shouldBe(3 * 60 * 60, "3 hours from now");
    }

    @Test
    public void daysFromNow() throws Exception {
        shouldBe(3 * 24 * 60 * 60, "3 days from now");
    }

    @Test
    public void weeksFromNow() throws Exception {
        shouldBe(3 * 7 * 24 * 60 * 60, "3 weeks from now");
    }

    @Test
    public void monthsFromNow() throws Exception {
        shouldBe(3 * 31 * 24 * 60 * 60, "3 months from now");
    }

    @Test
    public void yearsFromNow() throws Exception {
        shouldBe(3L * 366L * 24L * 60L * 60L, "3 years from now");
    }

    @Test
    public void minutesFromNow() throws Exception {
        shouldBe(12 * 60, "12 minutes from now");
    }

    private void shouldBe(long differenceInSeconds, String expectedResult) {
        String formattedTime = p.format(new Date(differenceInSeconds * 1000));
        assertEquals(expectedResult, formattedTime);
    }

}
