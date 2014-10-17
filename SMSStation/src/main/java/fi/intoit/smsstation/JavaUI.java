/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;


/**
 *
 * @author lasa
 */
public class JavaUI implements Runnable  {
    private JFrame frame;
    private SignalRConnection signal;
    // JUST FOR TESTING:
    private SMSStore store;
    private QueueWorker queueWorker;
    private MessageTableModel MTM;
    private Settings settings;
    
    public JavaUI() { 
        // JUST FOR TESTING
        store = new SMSStore();
        
        store.addMessage(new SMS("0404","Eka Viesti"));
        store.addMessage(new SMS("020202","Toka Viesti"));
        store.addMessage(new SMS("118","Kolmas teskstari"));
        store.addMessage(new SMS("444","nelkku teskstari"));
        store.addMessage(new SMS("555","femma teskstari"));
        store.getMessage(1).setStatus("queued");
        store.getMessage(4).setStatus("queued");
        queueWorker = new QueueWorker(store, new Settings());
        
        signal = new SignalRConnection(store, MTM);
        
    }
      @Override
    public void run() {
        frame = new JFrame("SMS Station");
        frame.setPreferredSize(new Dimension(600, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
        
    }
    
    private void createComponents(Container container) {
            BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
            container.setLayout(layout);
            JLabel label = new JLabel("Queue:n koko: ");
            JButton button = new JButton("Handle Message!");
            JTextArea newSMS = new JTextArea(); 
            JTextField newSMSNumber = new JTextField();
            JButton newSMSButton = new JButton("Put SMS to Qeueu");
            System.out.println("Tehdäänactionlisterner");

            MessageTableModel MTM = new MessageTableModel(store);
            final JTable table = new JTable(MTM);
            
            queueWorker.printQueue();
//            button.addActionListener(new UIListener());
            button.addActionListener(new UIListener(store, queueWorker, MTM, signal));
            newSMSButton.addActionListener(new NewSMSListener(store,MTM, newSMSNumber, newSMS));
            container.add(label);
            container.add(button);
            container.add(table);
            container.add(newSMS);
            container.add(newSMSNumber);
            container.add(newSMSButton);
    
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
