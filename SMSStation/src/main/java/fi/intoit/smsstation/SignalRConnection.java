/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.intoit.smsstation;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.SignalRFuture;
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
            awaitConnection = connection.start();
            startSignalRConnection();
        }

        public void startSignalRConnection() {
            try {
                awaitConnection.get();
                hub.invoke( "Send", "SMSStation", "Connected" ).get();
            } catch (InterruptedException e) {
                System.out.println("ERROR signalr" + e);
            } catch (Exception e) {
                System.out.println("ERROR signalr" + e);
            }
            System.out.println("Connected to:" + host);
        }
}
