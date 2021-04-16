package database;

import org.junit.Test;

import static org.junit.Assert.*;

public class loginTest {

    @Test
    public void connect() {
        assertEquals(true, database.login.connect("kyle","password123"));
        assertEquals(false, database.login.connect("joe","password123"));
        assertEquals(false, database.login.connect("tyler","password123"));
        assertEquals(false, database.login.connect("asdadf","sdfdase"));
    }
}