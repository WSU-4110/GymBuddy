import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class runnerTest {

    @Test
    void getDoesCompete() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals("does compete",jenna.getDoesCompete());
    }

    @Test
    void getDistance() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals(5.5f,jenna.getDistance());
    }

    @Test
    void getDistanceOrSprint() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals("distance",jenna.getDistanceOrSprint());
    }

    @Test
    void getInOrOut() {
        runner jenna = new runner("outdoors","does compete","distance", 5.5f);
        assertEquals("outdoors",jenna.getInOrOut());
    }
}