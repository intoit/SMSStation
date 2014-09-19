/*
 * (c) Lauri Savolainen / intoit oy
 */

package fi.intoit.smsstation;

/**
 *
 * @author lasa
 */
public class Main {
    public static void main(String[] Args) {
        Settings settings = new Settings();
        settings.setGSMNumber("050-555333222");
        System.out.println("Asetettiin puhelinnumeroksi: " + settings.getGSMNumber());
        
        SMSStore store = new SMSStore();
        
        store.addMessage(new SMS("0404","Eka Viesti"));
        store.addMessage(new SMS("020202","Toka Viesti"));
        store.addMessage(new SMS("118","Kolmas teskstari"));
        store.addMessage(new SMS("444","nelkku teskstari"));
        store.addMessage(new SMS("555","femma teskstari"));
        store.getMessage(1).setStatus("queued");
        store.getMessage(4).setStatus("queued");
        QueueWorker queueWorker = new QueueWorker(store);
        queueWorker.printQueue();
    }
}
