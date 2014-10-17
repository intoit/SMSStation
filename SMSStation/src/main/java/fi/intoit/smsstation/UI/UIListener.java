package fi.intoit.smsstation.UI;
import fi.intoit.smsstation.MessageTableModel;
import fi.intoit.smsstation.QueueWorker;
import fi.intoit.smsstation.SMS;
import fi.intoit.smsstation.SMSStore;
import fi.intoit.smsstation.SignalRConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Listener for Manually Handling messages
 * @author lasa
 */
public class UIListener implements ActionListener {
    private QueueWorker qw;
    private MessageTableModel mtm;
    private SMSStore store;
    private SignalRConnection signal;
    public UIListener(SMSStore store, QueueWorker qw, MessageTableModel mtm, SignalRConnection signal) {
       
        System.out.println("uilisternerluotu:");
        this.qw = qw;
        this.mtm = mtm;
        this.store = store;
        this.signal = signal;
        this.qw.printQueue();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        qw.printQueue();
        qw.HandleMessages();
        signal.sendInform("Handled Message Manually!!");
        qw.refreshQueue();
        mtm.fireTableDataChanged();
        
    }
}
