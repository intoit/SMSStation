package fi.intoit.smsstation;

import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author lasa
 */

public class SettingsTest {

    @Test
    public void tryAlwaysPasstest() {

    }
    @Test
    public void storeGSMNumber() {
    //assert(false);
    }
    @Test
    public void getRightGSMNumber() {
        Settings settings = new Settings();
        String number = "0404040404";
        settings.setGSMNumber(number);
        assertEquals("Set number is same as get",number,settings.getGSMNumber());
    }
}
