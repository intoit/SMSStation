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
 *
 * @author lasa
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
 
        public void setupSubscriptions() {
                hub.subscribe( new Object() {
                    	public void queueSMS(String name,String message) {
                            store.addMessage(new SMS(name,message));
                            MTM.fireTableDataChanged();
                            System.out.println("debug:got these from signalr " + name + " : " + message);
                        }
                });
                
                /*
                ANOTHER WAY
                hub.on("broadcastMessage", new SubscriptionHandler2<String, String>() {

                    @Override
                    public void run(String parameter1, String parameter2) {
                        System.out.println("VIESTI" + parameter1 + " | " + parameter2);
                    }
                }, String.class, String.class);
                */
        
        }
        
        public void sendInform(String message) {
            hub.invoke("Inform", "SMSStation", message);
        }
}
