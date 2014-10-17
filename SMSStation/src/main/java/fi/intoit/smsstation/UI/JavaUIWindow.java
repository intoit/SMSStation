/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation.UI;
import fi.intoit.smsstation.MessageTableModel;
import fi.intoit.smsstation.NewSMSListener;
import fi.intoit.smsstation.SMSStore;
import fi.intoit.smsstation.SignalRConnection;
import fi.intoit.smsstation.QueueWorker;
import java.awt.Color;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author lasa
 */
public class JavaUIWindow implements Runnable {
    	private	JTabbedPane tabbedPane;
	private	JPanel statusPanel;
	private	JPanel settingsPanel;
	private	JPanel logPanel;
        private JFrame frame;
        private JPanel topPanel;
        private JPanel testPanel;
        private JTextArea logArea;
        
        private SMSStore store;
        private QueueWorker qw;
        private MessageTableModel MTM;
        private SignalRConnection signal;
        public JavaUIWindow(SMSStore store, MessageTableModel MTM, QueueWorker qw, SignalRConnection signal) {
            this.store = store;
            this.MTM = MTM;
            this.qw = qw;
            this.signal = signal;
            

        }
        
        @Override
        public void run() {

            // Create Main frame with title
            frame = new JFrame("SMS Station");
        
            // Put all properties for window
            frame.setTitle("SMS Station");
            frame.setSize(800,800);
            frame.setBackground(Color.GRAY);
            frame.setPreferredSize(new Dimension(800, 800));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // Create TabbedPPane on top
            tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            
            // Create 
            statusPanel = new JPanel();
            settingsPanel = new JPanel();
            logPanel = new JPanel();
            testPanel = new JPanel();
            createStatusP(statusPanel);
            createSettingsP(settingsPanel);
            createLogP(logPanel);
            createTestP(testPanel);
            
            // add Panels to top Tab
            tabbedPane.addTab( "Status", statusPanel);
            tabbedPane.addTab( "Settings", settingsPanel);
            tabbedPane.addTab( "Log", logPanel);
            tabbedPane.addTab( "Test", testPanel);
            
            // Add tab to main frame
            frame.getContentPane().add(tabbedPane);
            frame.getContentPane().setLayout(new GridLayout(1, 1));        
            frame.pack();
            frame.setVisible(true);
        }
        
        public void createStatusP(Container container) {
            BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
            container.setLayout(layout);
            JLabel label = new JLabel("Queue:n koko: ");
            JButton button = new JButton("Manually Handle Message!");
            button.addActionListener(new UIListener(store, qw, MTM, signal));
            //MessageTableModel MTM = new MessageTableModel(store);
            final JTable table = new JTable(MTM);
            
            container.add(label);
            container.add(button);
            container.add(table);
            
        }
        public void createSettingsP(Container container) {
            BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
            container.setLayout(layout);            
        }
        public void createLogP(Container container) {
            BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
            container.setLayout(layout);
            logArea = new JTextArea();
            JScrollPane logAreaScrollPane = new JScrollPane(logArea);
            logArea.setEditable(false);
            container.add(logAreaScrollPane);
        }
        
        public void createTestP(Container container) {
            BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
            container.setLayout(new GridLayout(5, 1)); 
            JLabel labelSMS = new JLabel("Message:");
            JTextArea newSMS = new JTextArea(); 
            JLabel labelNumber = new JLabel("To Number:");
            JTextField newSMSNumber = new JTextField();
            JButton newSMSButton = new JButton("Put SMS to Qeueu");
            container.add(labelSMS);
            container.add(newSMS);
            container.add(labelNumber);
            container.add(newSMSNumber);
            container.add(newSMSButton);
            newSMSButton.addActionListener(new NewSMSListener(store,MTM, newSMSNumber, newSMS));
        }
}
