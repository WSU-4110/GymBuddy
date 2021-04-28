import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class bodybuilderTest {

    @Test
   public void getCurrWeight() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals(183.5f,steve.getCurrWeight(),0);
    }

    @Test
    public void getStageWeight() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals(170.1f,steve.getStageWeight(),0);
    }

    @Test
    public void getBulkOrCut() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals("cut",steve.getBulkOrCut());
    }

    @Test
    public void getDoesCompete() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals("does not compete",steve.getDoesCompete());
    }

    @Test
    public void getNatty() {
        bodybuilder steve = new bodybuilder("cut","does not compete"
                , 170.1f, 183.5f,"natty");
        assertEquals("natty",steve.getNatty());
    }
}