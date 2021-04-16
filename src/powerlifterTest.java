import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class powerlifterTest {

    @Test
    void getNatty() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals("not natty", john.getNatty());
    }

    @Test
    void getDoesCompete() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals("does compete", john.getDoesCompete());
    }

    @Test
    void getMaxBench() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals(295, john.getMaxBench());
    }

    @Test
    void getMaxDeadlift() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals(495, john.getMaxDeadlift());
    }

    @Test
    void getMaxSquat() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals(405, john.getMaxSquat());
    }

    @Test
    void getThousandPoundClub() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals("in thousand pound club", john.getThousandPoundClub());
    }
}