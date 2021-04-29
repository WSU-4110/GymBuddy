import org.junit.Test;

import static org.junit.Assert.*;

public class userTest {

    @Test
    public void getFirstNameTest(){
        user me = new user();
        me.setFirstName("Ragib");
        assertEquals("Ragib", me.getFirstName());
    }

    @Test
    public void getBirthdayDay(){
        user me = new user();
        me.setBirthdayDay(23);
        assertEquals(23, me.getBirthdayDay());
    }

    @Test
    public void getPhoneNumber(){
        user me = new user();
        me.setPhoneNumber("313-695-8675");
        assertEquals("313-695-8675", me.getPhoneNumber());
    }

    @Test
    public void getGender(){
        user me = new user();
        me.setGender("Male");
        assertEquals("Male", me.getGender());
    }

    @Test
    public void getBirthdayMonth(){
        user me = new user();
        me.setBirthdayMonth(9);
        assertEquals(9, me.getBirthdayMonth());
    }

    @Test
    public void getBirthdayYear(){
        user me = new user();
        me.setBirthdayYear(1993);
        assertEquals(1993, me.getBirthdayYear());
    }
}
