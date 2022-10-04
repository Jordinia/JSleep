package RizkiAwantaJordhieJSleepKM;

import java.util.Calendar;

/**
 * Invoice class contains invoice information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (3 - CS4 - 04/10/2022)
 */
public class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public int buyerId;
    public int renterId;
    //public String time;
    public Calendar time;
    public enum RoomRating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
    public enum PaymentStatus{
        FAILED,
        WAITING,
        SUCCESS
    }
    public RoomRating rating;
    public PaymentStatus status;
    /**
     * Constructors and overloading for objects of class Invoice
     */
    protected Invoice(int id, int buyerId, int renterId)
    {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.time = Calendar.getInstance();
    }

    public Invoice(int id, Account buyer, Renter renter)
    {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
        this.time = Calendar.getInstance();
    }
    /**
     * print method used for testcae
     *
     *
     * @return    the attributes of this class
     */
    public String print()
    {
        return "\nTime= " + time + "\nbuyerId= " + buyerId + "\nrenterId= " + renterId;
    }
}

