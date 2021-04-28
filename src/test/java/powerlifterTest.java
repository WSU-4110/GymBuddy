import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class powerlifterTest {

    @Test
    public void getNatty() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals("not natty", john.getNatty());
    }

    @Test
    public  void getDoesCompete() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals("does compete", john.getDoesCompete());
    }

    @Test
    public void getMaxBench() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals(295, john.getMaxBench());
    }

    @Test
    public void getMaxDeadlift() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals(495, john.getMaxDeadlift());
    }

    @Test
    public void getMaxSquat() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals(405, john.getMaxSquat());
    }

    @Test
    public void getThousandPoundClub() {
        powerlifter john = new powerlifter("in thousand pound club",
                "does compete", 295,495,405,"not natty");
        assertEquals("in thousand pound club", john.getThousandPoundClub());
    }
}