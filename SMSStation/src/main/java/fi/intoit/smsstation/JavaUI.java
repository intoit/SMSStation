/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
/**
 *
 * @author lasa
 */
public class JavaUI implements Runnable  {
    private JFrame frame;
    
    // JUST FOR TESTING:
    private SMSStore store;
    private QueueWorker queueWorker;
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
        queueWorker = new QueueWorker(store);
        queueWorker.printQueue();
        
    }
      @Override
    public void run() {
        frame = new JFrame("SMS Station");
        frame.setPreferredSize(new Dimension(300, 500));

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
            button.addActionListener(new UIListener(queueWorker));
            container.add(label);
            container.add(button);
    
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
