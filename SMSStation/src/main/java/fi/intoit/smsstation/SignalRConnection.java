/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler2;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler1;
/**
 * Class for connecting SMS Station for another system
 * Uses SignalR from Microsoft 
 * @author Lauri Savolainen
 */
public class SignalRConnection {
        private String host = "http://hystation.azurewebsites.net";
        private HubConnection connection;
        private HubProxy hub;
        private SignalRFuture<Void> awaitConnection;
        private SMSStore store;
        private MessageTableModel MTM;
        SignalRConnection(SMSStore store, MessageTableModel MTM)  {
            this.store = store;
            this.MTM = MTM;
            this.connection = new HubConnection( host );
            this.hub = connection.createHubProxy( "sMSHub" );
            setupSubscriptions();
            this.awaitConnection = connection.start();
            try {
                this.awaitConnection.get();
                hub.invoke( "Inform", "SMSStation", "Connected" ).get();
                
            } catch (InterruptedException e) {
                System.out.println("ERROR signalr" + e);
            } catch (Exception e) {
                System.out.println("ERROR signalr" + e);
            }
            System.out.println("Connected to:" + host);
        }
        /**
         * Subscribe signalR function queueSMS that receives 
         * Phone number and message from other system
         * Crates new SMS and put it to Store and changes status to
         * queued
         */
        public void setupSubscriptions() {
                hub.subscribe( new Object() {
                    	public void queueSMS(String number,String message) {
                            SMS temp = new SMS(number,message);
                            
                            temp.setStatus("queued");
                            store.addMessage(temp);
                            MTM.fireTableDataChanged();
                            System.out.println("debug:got these from signalr " + number + " : " + message);
                        }
                });
              
        
        }
        /**
         * Send Message to SignalR-server
         * @param message Message that needs to be sent to server
         */
        public void sendInform(String message) {
            hub.invoke("Inform", "SMSStation", message);
        }
}
