/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.intoit.smsstation;

/**
 *
 * @author lasa
 */
public class QeueWorker {
    private SMSQueue queue;
    
    public void QueueWorker() {
        queue = new SMSQueue();
    }
    public void HandleMessages() {
        
        
        new TelephonyMock().sendTextMessage(null, null, null);
    }
}
