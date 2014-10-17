package fi.intoit.smsstation;
import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 * SMS Queue keeps messages in queue that haven't been sent yet
 * @author (c) Lauri Savolainen / intoit oy
 * 
 */
public class SMSQueue {
    private PriorityQueue<SMS> waiting;
    private SMSStore store;
   
    /**
    * Connect SMSQueue to SMSStore
    * @param store 
    */ 
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
     * Add SMS to Queue
     * @param message 
     */
    public void addtoQueue(SMS message) {
        message.setStatus("queued");
        store.addMessage(message);
        waiting.add(message);
    }
    /**
     * Get Queue Length
     * @return INT 
     */
    public int getQueueLength() {
        refreshQueue();
        return waiting.size();
    }
    /**
     * Get next SMS that need sending
     * @return SMS Message
     */
    public SMS getNextSMS() {
        if (this.waiting.isEmpty()) {
            // FIX: dummy solution
            //return new SMS("","");
            System.out.println("ITS EMPTY!!");
            return null;
        } else {
            return this.waiting.poll();
        }
        
    }
    /**
     * Prints Messages in Queue
     */
    public void printQueue() {
        refreshQueue();
        PriorityQueue<SMS> tempQueue = waiting;
        System.out.println(waiting.toString());
        if (tempQueue.isEmpty()) {
             System.out.println("Empty Queue");
        } else {
            for (int i = 0; i < tempQueue.size()+1; i++) {
                SMS temp = tempQueue.poll();
                System.out.println(temp.toString());
            }
        }
    }
    /**
     * Just in case manual refresh of waiting queue from messages FIX?
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
