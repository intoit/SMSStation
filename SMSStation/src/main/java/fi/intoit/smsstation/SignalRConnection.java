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
        
        SignalRConnection() {
            connection = new HubConnection( host );
            hub = connection.createHubProxy( "sMSHub" );

            
            startSignalRConnection();
                


        }

        public void startSignalRConnection() {
            awaitConnection = connection.start();
            try {
                awaitConnection.get();
                

                
                hub.subscribe( new Object() {
                    	public void SendSMS(String name,String message) {
                            System.out.println("NY TULI");
                        }
                        
                        public void Inform(String name,String message) {
                            System.out.println("NY TULI i");
                        }
                        public void inform(String name) {
                            System.out.println("NY TULI iinfoorm");
                        }
                });
                
                
                hub.on( "inform", new SubscriptionHandler1<String>() {
                    @Override
                    public void run( String status ) {
                       // Since we are updating the UI,
                       // we need to use a handler of the UI thread.
                       System.out.println("NTYTYTYT");
                       } 
                    }, String.class );
                
                
                hub.invoke( "Inform", "SMSStation", "Connected" ).get();
                hub.invoke( "SendSMS", "SMSStation", "SendSMSConnected" ).get();
                
                
/*                hub.on("SendSMS", new SubscriptionHandler2<String, String>() {

                    @Override
                    public void run(String parameter1, String parameter2) {
                        System.out.println("VIESTI" + parameter1 + " | " + parameter2);
                    }
                }, String.class, String.class);
                
                hub.on("SendSMS", new SubscriptionHandler1<String>() {
                    @Override
                    public void run(String parameter1) {
                        System.out.println("VIESTI1" + parameter1);
                    }
                }, String.class);
  */              
                
            } catch (InterruptedException e) {
                System.out.println("ERROR signalr" + e);
            } catch (Exception e) {
                System.out.println("ERROR signalr" + e);
            }
            System.out.println("Connected to:" + host);
        }
 
        
        
        public void sendInform(String message) {
            hub.invoke("Inform", "SMSStation", message);
        }
}
