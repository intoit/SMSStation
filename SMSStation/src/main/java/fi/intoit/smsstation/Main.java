/*
 * (c) Lauri Savolainen / intoit oy
 */

package fi.intoit.smsstation;
import fi.intoit.smsstation.UI.JavaUIWindow;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
/**
 *
 * @author lasa
 */
public class Main {

    /**
     *
     * @param Args
     */
    public static void main(String[] Args) {
        Settings settings;
        SMSStore store;
        MessageTableModel MTM;
        QueueWorker qw;
        SignalRConnection signal;
        
        settings = new Settings();
        store = new SMSStore();
        qw = new QueueWorker(store, settings);
        MTM = new MessageTableModel(store);
        signal = new SignalRConnection(store, MTM);
        
        // Let's create UI and run it
        JavaUIWindow Jui = new JavaUIWindow(store, MTM, qw, signal);
        Jui.run();
    }
}
