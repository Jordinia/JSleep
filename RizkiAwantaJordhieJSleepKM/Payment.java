package RizkiAwantaJordhieJSleepKM;


import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Payment class contains payment information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (2 - CS4 - 04/10/2022)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Calendar to;
    public Calendar from;
    private int roomId;
    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, int roomId)
    {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
    }
    public Payment(int id, Account buyer, Renter renter, int roomId)
    {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
    }
    public String getDuration(){
        SimpleDateFormat dateDuration = new SimpleDateFormat("dd MMMMM yyyy");
        to.add(Calendar.DATE, 2);
        return dateDuration.format(this.from.getTime()) + " - " + dateDuration.format(this.to.getTime());
    }
    public String getTime(){
        SimpleDateFormat dateTime = new SimpleDateFormat("dd MMMMM yyyy");
        return  "Formatted Date = " + dateTime.format(this.time.getTime());
    }
    /**
     * print method used for testcae
     *
     *
     * @return    the attributes of this class
     */
    public String print()
    {
        return "\nroomId= " + roomId + "\nto= " + to + "\nfrom= " + from;
    }
    
}

