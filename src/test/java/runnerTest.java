import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class runnerTest {

    @Test
    public void getDoesCompete() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals("does compete",jenna.getDoesCompete());
    }

    @Test
    public  void getDistance() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals(5.5f,jenna.getDistance(),0);
    }

    @Test
    public  void getDistanceOrSprint() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals("distance",jenna.getDistanceOrSprint());
    }

    @Test
    public void getInOrOut() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals("outdoors",jenna.getInOrOut());
    }
}