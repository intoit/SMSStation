/*
 * (c) Lauri Savolainen / intoit oy
 */

package fi.intoit.smsstation;

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
        Settings settings = new Settings();
        settings.setGSMNumber("050-555333222");
        System.out.println("Asetettiin puhelinnumeroksi: " + settings.getGSMNumber());
        

        // Let's make ui
        JavaUI ui = new JavaUI();
        ui.run();
    }
}
