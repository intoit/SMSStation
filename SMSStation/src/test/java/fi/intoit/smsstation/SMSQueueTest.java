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
public class SMSQueueTest {
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
    public void createdEmptyStore() {
        
    }
    @Test
    public void isMessageGoingtoWaitingList() {
        store.getMessage(1).setStatus("queued");
        queue.refreshQueue();
        assertEquals(1,queue.getQueueLength());
    }
    @Test
    public void getEmptyNextSMS() {
            // needs thinking
            assertEquals(null,queue.getNextSMS());
    }
    @Test
    public void addOneMessagetoQueue() {
        assertEquals(0,queue.getQueueLength());
        queue.addtoQueue(new SMS("04444","Neljäs menee quee"));
        assertEquals(1,queue.getQueueLength());
        
    }
    @Test
    public void addTwoMessagestoQueue() {
        assertEquals(0,queue.getQueueLength());
        queue.addtoQueue(store.getMessage(1));
        queue.addtoQueue(new SMS("04444","Neljäs menee quee"));
        assertEquals(2,queue.getQueueLength());
    }
    @Test
    public void addTwoMessageAnGetOne() {
        assertEquals(0,queue.getQueueLength());
        queue.addtoQueue(store.getMessage(1));
        queue.addtoQueue(new SMS("04444","Neljäs menee quee"));
        assertEquals(2,queue.getQueueLength());
        SMS next = queue.getNextSMS();
        assertEquals(1,queue.getQueueLength());
    }
}
