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
