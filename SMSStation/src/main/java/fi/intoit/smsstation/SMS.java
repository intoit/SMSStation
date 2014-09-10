/*
 * (c) Lauri Savolainen / intoit oy
 */
package fi.intoit.smsstation;
import java.util.Date;


/**
 *
 * @author lasa
 */
public class SMS {
    private String Status;
    private String Content;
    private Date Created;
    private String ToNumber;

    public SMS(String ToNumber, String Content) {
        this.ToNumber = ToNumber;
        this.Content = Content;
        this.Status = "created";
        this.Created = new Date();
    }
    public String getToNumber() {
        return ToNumber;
    }

    public void setToNumber(String ToNumber) {
        this.ToNumber = ToNumber;
    }
    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date Created) {
        this.Created = Created;
    }
    
    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
