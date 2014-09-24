package fi.intoit.smsstation;
import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 * SMS Queue keeps messages in queue that haven't been sent yet
 * @author (c) Lauri Savolainen / intoit oy
 */
public class SMSQueue {
    private PriorityQueue<SMS> waiting;
    private SMSStore store;
    
    SMSQueue(SMSStore store) {
        this.store = store;
        waiting = new PriorityQueue<>();
        // Let's add all queued messages in waiting array
        for (int i =0; i < store.getNumberOfMessages(); i++) {
            if (this.store.getMessage(i).getStatus().contains("queued")) {
                this.waiting.add(this.store.getMessage(i));
            }
        }
        
        
    }
    /**
     * Get Queue Length
     * @return 
     */
    public int getQueueLength() {
        return waiting.size();
    }
    /**
     * Get next SMS that need sending
     * @return 
     */
    public SMS getNextSMS() {
        if (this.waiting.isEmpty()) {
            // FIX: dummy solution
            return new SMS("","");
        } else {
            return this.waiting.poll();
        }
        
    }
    /**
     * Prints Messages in Queue
     */
    public void printQueue() {
        PriorityQueue<SMS> tempQueue = waiting;
        for (int i = 0; i < tempQueue.size()+1; i++) {
            SMS temp = tempQueue.poll();
            System.out.println(temp.toString());
        }
    }
    /**
     * Just in case manual refresh of waiting queue from messages
     */    
    public void refreshQueue() {
        // Let's clear the list
        this.waiting.clear();
        // let's take all queued messages back to list
        for (int i =0; i < store.getNumberOfMessages(); i++) {
            if (this.store.getMessage(i).getStatus().contains("queued")) {
                this.waiting.add(this.store.getMessage(i));
            }
        }
    }
    
}
