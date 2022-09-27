package RizkiAwantaJordhieJSleepKM;


/**
 * Invoice class contains invoice information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (1 - 27/09/2022)
 */
public class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public int buyerId;
    public int renterId;
    public String time;

    /**
     * Constructors and overloading for objects of class Invoice
     */
    protected Invoice(int id, int buyerId, int renterId, String time)
    {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }

    public Invoice(int id, Account buyer, Renter renter, String time)
    {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
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
