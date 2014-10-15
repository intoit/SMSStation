package fi.intoit.smsstation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
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
        System.out.println("Action!!!!");
        qw.HandleMessages();
        qw.refreshQueue();
        signal.sendInform("Handlattiin!!");
        SMS daa = new SMS("05050333","actionissa tehty");
        daa.setStatus("queued");
//        store.addMessage(daa);        
        qw.refreshQueue();
        //qw.printQueue();
        mtm.fireTableDataChanged();
        
    }
}
