/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author lasa
 */
public class UIListener implements ActionListener {
    private QueueWorker qw;
    
    public UIListener(QueueWorker qw) {
        this.qw = qw;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Action!!!!");
        qw.HandleMessages();
        qw.printQueue();
    }
}
