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
       
        System.out.println("uilisternerluotu:");
        this.qw = qw;

        qw.printQueue();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        qw.printQueue();
        System.out.println("Action!!!!");
        qw.HandleMessages();
        qw.printQueue();
    }
}
