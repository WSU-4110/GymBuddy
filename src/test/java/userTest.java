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
    @Test
    public void testModify(){
        user user1 = new user("first","last","111111111","user@gmail.com",
                "male",2000,01,01);
        assertEquals("111111111", user1.phoneNumber,"111111111");
    }

    @Test
    public void displayTest(){
        user user1 = new user("first","last","111111111","user@gmail.com",
                "male",2000,01,01);
        assertEquals("last", user1.lastName,"last");
    }

    @Test
    public void setFirstNameTest(){
        user user1 = new user();
        user1.setFirstName("firstName");
        assertEquals("firstName", user1.firstName,"firstName");
    }

    @Test
    public void setLasttNameTest(){
        user user1 = new user();
        user1.setLastName("lastname");
        assertEquals("lastName", user1.lastName,"lastname");
    }

    @Test
    public void setNumberTest(){
        user user1 = new user();
        user1.setPhoneNumber("000-000-0000");
        assertEquals("000-000-0000", user1.phoneNumber,"000-000-0000");
    }
}


