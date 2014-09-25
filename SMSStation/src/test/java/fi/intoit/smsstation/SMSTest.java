/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.intoit.smsstation;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Date;
/**
 *
 * @author lasa
 */
public class SMSTest {
    SMS smsMessage;
    SMS secondMessage;
    Date now;

    @Before
    public void setupUp() {
        smsMessage = new SMS("05055555","Testiviesti");
        now = new Date();
        
    }
    @Test
    public void CreatedMessageGoingtoRightNumber() {
        assertEquals("05055555", smsMessage.getToNumber());
    }
    @Test
    public void ChangedMessageChangedText() {
        smsMessage.setContent("uusi viesti");
        assertEquals("uusi viesti",smsMessage.getContent());
    }
    @Test
    public void SettedStatusIsOk() {
        smsMessage.setStatus("send");
        assertEquals("send",smsMessage.getStatus());
    }
    @Test
    public void SMSStatusIsCreatedfirst() {
        assertEquals("created",smsMessage.getStatus());
    }
    @Test
    public void CreationDateisright() {
        assertEquals(now, smsMessage.getCreated());
    }
    @Test
    public void NewerSMSisSmaller() {
        //FIX
        secondMessage = new SMS("0222","Tokaviesti");
        secondMessage.setCreated(new Date(new Date().getTime()+(1000 * 60 * 60 * 24)));
        Date now2 = new Date();
        assertEquals(-1, smsMessage.compareTo(secondMessage));
        //assertEquals(1, secondMessage.compareTo(smsMessage));

    }
    @Test 
    public void setCreatedDate() {
        // Really weird...FIX
        secondMessage = new SMS("0222","Tokaviesti");
        Date old = secondMessage.getCreated();
        secondMessage.setCreated(new Date(new Date().getTime()+(1000 * 60 * 60 * 24)));
        assertEquals(false, secondMessage.getCreated().equals(old));
        
    }
}
