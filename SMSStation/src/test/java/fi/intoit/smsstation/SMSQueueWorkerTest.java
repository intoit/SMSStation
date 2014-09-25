/*
 * (c) Lauri Savolainen / intoit oy
 */
    
package fi.intoit.smsstation;
import org.junit.*;
import static org.junit.Assert.*;
/**
/**
 *
 * @author lasa
 */
public class SMSQueueWorkerTest {
    SMSStore store;
    SMSQueue queue;
    @Before
    public void setupUp() {
        store = new SMSStore();
        
        store.addMessage(new SMS("0404","Eka Viesti"));
        store.addMessage(new SMS("020202","Toka Viesti"));
        store.addMessage(new SMS("118","Kolmas teskstari"));
        queue = new SMSQueue(store);
    }
    @Test
    public void handleMessages() {
        
    }
}
