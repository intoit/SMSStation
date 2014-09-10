package fi.intoit.smsstation;

import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author lasa
 */

public class SettingsTest {
    Settings settings;
    @Before
    public void setupUp() {
        settings = new Settings();
    }
    @Test
    public void getRightGSMNumber() {

        String number = "0404040404";
        settings.setGSMNumber(number);
        assertEquals("Set number is same as get",number,settings.getGSMNumber());
    }
    @Test
    public void CheckSettingUsername() {
        settings.setUsername("Uuseri");
        assertEquals("Uuseri", settings.getUsername());
    }
    @Test
    public void CheckSettingsPassword() {
        settings.setPassword("Passu98");
        assertEquals("Passu98", settings.getPassword());
    }
    
}
