/*
 * (c) Lauri Savolainen / intoit oy
 */

package fi.intoit.smsstation;

import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author lasa
 */
public class SMSStoreTest {
    SMSStore store;
    @Before
    public void setupUp() {
        store = new SMSStore();
    }
    @Test
    public void createdEmptyStore() {
        
    }
    @Test
    public void showNumberofMessages() {
        store.addMessage(new SMS("0404","Diipa"));
        store.addMessage(new SMS("0404","Diipa"));
        store.addMessage(new SMS("0404","Diipa"));
        assertEquals(3,store.getNumberOfMessages());
    }
           
}
