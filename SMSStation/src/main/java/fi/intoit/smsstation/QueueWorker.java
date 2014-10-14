/**
 * @author (c) Lauri Savolainen / intoit oy
 * @since 2014-09-24
 * 
 */

package fi.intoit.smsstation;

/**
 *
 * @author lasa
 */
public class QueueWorker {
    private SMSQueue queue;
    
    QueueWorker(SMSStore store) {
        this.queue = new SMSQueue(store);
        queue.refreshQueue();
    }
    
    public void refreshQueue() {
        this.queue.refreshQueue();
    }
    /**
     * Handles messages in queue
     */
    public void HandleMessages() {
        
        if (queue.getQueueLength() > 0) {
            SMS currentMessage;
            currentMessage = queue.getNextSMS();
            
            // Let's try to send textmessage
            try {
                new TelephonyMock().sendTextMessage(currentMessage.getToNumber(), null, currentMessage.getContent());
                currentMessage.setStatus("sent");
            } catch (Exception e) {
                currentMessage.setStatus("error");
            }
        }
        
        
    }
    /**
     * Print's queue
     */
    public void printQueue() {
        queue.printQueue();
    }
}
