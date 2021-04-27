import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bodybuilderTest {

    @Test
    void getCurrWeight() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals(183.5f,steve.getCurrWeight());
    }

    @Test
    void getStageWeight() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals(170.1f,steve.getStageWeight());
    }

    @Test
    void getBulkOrCut() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals("cut",steve.getBulkOrCut());
    }

    @Test
    void getDoesCompete() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals("does not compete",steve.getDoesCompete());
    }

    @Test
    void getNatty() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals("natty",steve.getNatty());
    }
}