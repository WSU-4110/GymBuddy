import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GymTest {

    private Gym gym;

    @Before
    public void setUp() throws Exception {
        gym = new Gym("firstName", "lastName", 25, "0764815784", "customer@mail.com", "CA");
    }

    @Test
    public void getFirstNameTest() {
        assertEquals("firstName", gym.getFirstName());
    }

    @Test
    public void setFirstNameTest() {
        String newFirstName = "newFirstName";
        gym.setFirstName(newFirstName);
        assertEquals(newFirstName, gym.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertEquals("lastName", gym.getLastName());
    }

    @Test
    public void setLastNameTest() {
        String newLastName = "newLastName";
        gym.setLastName(newLastName);
        assertEquals(newLastName, gym.getLastName());
    }

    @Test
    public void getAgeTest() {
        assertEquals(25, gym.getAge());
    }

    @Test
    public void setAgeTest() {
        int newAge = 30;
        gym.setAge(newAge);
        assertEquals(newAge, gym.getAge());
    }

    @Test
    public void getPhoneNoTest() {
        assertEquals("0764815784", gym.getPhoneNo());
    }

    @Test
    public void setPhoneNoTest() {
        String newPhoneNumber = "0784512350";
        gym.setPhoneNo(newPhoneNumber);
        assertEquals(newPhoneNumber, gym.getPhoneNo());
    }

    @Test
    public void getEmailTest() {
        assertEquals("customer@mail.com", gym.getEmail());
    }

    @Test
    public void setEmailTest() {
        String newEmail = "newCustomer@mail.com";
        gym.setEmail(newEmail);
        assertEquals(newEmail, gym.getEmail());
    }

    @Test
    public void getLocationTest() {
        assertEquals("CA", gym.getLocation());
    }

    @Test
    public void setLocationTest() {
        String newLocation = "TX";
        gym.setLocation(newLocation);
        assertEquals(newLocation, gym.getLocation());
    }
}