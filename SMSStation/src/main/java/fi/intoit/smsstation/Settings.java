/*
 * (c) Lauri Savolainen / intoit oy
 */


package fi.intoit.smsstation;

/**
 * Class for Settings
 * @author (c) Lauri Savolainen / intoit oy
 */
public class Settings {
    /**
     * Outbound GSM Number
     */
    private String GSMNumber;
    /**
     * Username and password for external system
     */
    private String Username;
    private String Password;
    /**
     * Time in second's between trying to send another message
     */
    private int SendingTimeLimit;

    public Settings() {
        /**
         * Default Sending timelimit is 10 seconds
         */
        this.SendingTimeLimit = 10;
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
            
    public String getGSMNumber() {
        return GSMNumber;
    }
    public void setGSMNumber(String number) {
        this.GSMNumber = number;
    }
    
    public int getSendingTimeLimit() {
        return this.SendingTimeLimit;
    }
    public void setSendingTimeLimit(int SendingTimeLimit) {
        this.SendingTimeLimit = SendingTimeLimit;
    }
}
