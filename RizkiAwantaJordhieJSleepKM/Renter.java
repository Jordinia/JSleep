package RizkiAwantaJordhieJSleepKM;


/**
 * Renter class contains renter information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (2 - 27/09/2022)
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public int phoneNumber = 0;
    public String address = "";
    public String username;

    /**
     * Constructors and overloading for objects of class Renter
     */
    public Renter(int id, String username)
    {
        super(id);
        this.username = username;
    }
    public Renter(int id, String username, String address)
    {
        super(id);
        this.username = username;
        this.address = address;
    }
    public Renter(int id, String username, int phoneNumber)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    public Renter(int id, String username, int phoneNumber, String address)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
