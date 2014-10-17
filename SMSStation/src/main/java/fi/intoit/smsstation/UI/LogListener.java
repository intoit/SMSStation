/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author lasa
 */
public class LogListener implements ActionListener {
    
    public LogListener() {
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Added log");
    }
}
