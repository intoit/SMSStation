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
    
    SMS first;
    SMS second;
    SMS third;
    
    @Before        
    public void setupUp() {
        store = new SMSStore();
        first = new SMS("0404","Eka Viesti");
        second = new SMS("020202","Toka Viesti");
        third = new SMS("118","Kolmas teskstari");
        store.addMessage(first);
        
        store.addMessage(second);
        store.addMessage(third);
        queue = new SMSQueue(store);
    }
    @Test
    public void handleMessagesInRightOrder() {
        third.setStatus("queued");
        first.setStatus("queued");
        queue.refreshQueue();
        assertEquals("Not working",queue.getNextSMS(), third);
    }
}
