/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.intoit.smsstation;

/**
 *
 * @author lasa
 */
// http://developer.android.com/reference/android/telephony/SmsManager.html
// public void sendTextMessage (String destinationAddress, String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent) 
public class TelephonyMock {
    
    public void sendTextMessage (String destinationAddress, String scAddress, String text) {
        System.out.println("Message sent: " + text);
    }
}
