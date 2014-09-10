/*
 * (c) Lauri Savolainen / intoit oy
 */

package fi.intoit.smsstation;
import java.util.ArrayList;
/**
 *
 * @author lasa
 */
public class SMSStore {
    private ArrayList<SMS> messages;
    
    public SMSStore() {
        this.messages = new ArrayList<>();
    }
    public void addMessage(SMS message) {
        messages.add(message);
    }
    public int getNumberOfMessages() {
        return messages.size();
    }
}
