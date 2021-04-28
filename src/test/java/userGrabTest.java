
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;

public class userGrabTest {

    @Test
    public void grab() {
        assertEquals(database.userGrab.grab("kyle","password123"),database.userGrab.grab("kyle","password123"));
        assertNotEquals(database.userGrab.grab("admin","password123"),database.userGrab.grab("kyle","password123"));
    }
}