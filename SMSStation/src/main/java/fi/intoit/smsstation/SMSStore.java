/**
 * @author  (c) Lauri Savolainen / intoit oy
 * 
 */

package fi.intoit.smsstation;
import java.util.ArrayList;
/**
 * Stores SMS Messages
 */
public class SMSStore {
    private ArrayList<SMS> messages;
    
    public SMSStore() {
        this.messages = new ArrayList<>();
    }
    /**
     * Add Message to Store
     * @param message SMS Message 
     */
    public void addMessage(SMS message) {
        messages.add(message);
    }
    /**
     * Return number of messages in Store
     * @return Number of messages in Store
     */
    public int getNumberOfMessages() {
        return messages.size();
    }
    /**
     * Return Certain message from Store
     * @param messageInt    Return SMS
     * @return 
     */
    public SMS getMessage(int messageInt) {
        return messages.get(messageInt);
    }
}
