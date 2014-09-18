/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.intoit.smsstation;
import java.util.ArrayList;

/**
 *
 * @author lasa
 */
public class SMSQueue {
    private ArrayList<SMS> waiting;
    private SMSStore store;
    
    SMSQueue(SMSStore store) {
        this.store = store;
        waiting = new ArrayList<>();
        // Let's add all queued messages in waiting array
        for (int i =0; i < store.getNumberOfMessages(); i++) {
            if (this.store.getMessage(i).getStatus().contains("queued")) {
                this.waiting.add(this.store.getMessage(i));
            }
        }
        
        
    }
    public int getQueueLength() {
        return waiting.size();
    }
    public SMS getNextSMS() {
        if (this.waiting.isEmpty()) {
            // FIX: dummy solution
            return new SMS("","");
        } else {
            return this.waiting.get(1);
        }
        
    }
    // Just in case manual refresh of waiting queue from messages
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
