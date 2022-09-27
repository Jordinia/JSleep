package RizkiAwantaJordhieJSleepKM;


/**
 * Payment class contains payment information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (1 - 27/09/2022)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public String to;
    public String from;
    private int roomId;
    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to)
    {
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to)
    {
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
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
