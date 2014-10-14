/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import fi.intoit.smsstation.SMSStore;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author lasa
 */
public class NewSMSListener implements ActionListener {
    private SMSStore store;
    private JTextField number;
    private JTextArea message;
    public NewSMSListener(SMSStore store, JTextField number, JTextArea message) {
        this.store = store;
        this.number = number;
        this.message = message;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        SMS newsms = new SMS(number.getText(),message.getText());
        newsms.setStatus("queued");
        store.addMessage(newsms);
    }
}
