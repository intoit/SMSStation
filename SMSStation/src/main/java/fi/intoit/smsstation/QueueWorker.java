/**
 * @author (c) Lauri Savolainen / intoit oy
 * @since 2014-09-24
 * 
 */

package fi.intoit.smsstation;

/**
 * Class manages Queue
 * @author lasa
 */
public class QueueWorker implements Runnable {
    private SMSQueue queue;
    private Settings settings;
    private Thread runner;
    private boolean runQueue;
    QueueWorker(SMSStore store, Settings settings) {
        this.queue = new SMSQueue(store);
        this.settings = settings;
        this.runQueue = true;
        queue.refreshQueue();
        runner = new Thread(this);
        runner.start();
    }
    
    public void refreshQueue() {
        this.queue.refreshQueue();
    }
    /**
     * Handles messages in queue
     */
    public void run() {
        System.out.println("Starting thread");
        while (runQueue) {
            try {
            Thread.sleep(settings.getSendingTimeLimit()*1000);
            System.out.println("Running thread");
            HandleMessages();
            printQueue();
        } catch (Exception e) {
                
                }
        }
    }
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
