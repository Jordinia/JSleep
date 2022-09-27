package RizkiAwantaJordhieJSleepKM;


/**
 * Account class contains room details information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (2 - 27/09/2022)
 */
public class Room extends Serializable {
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    /**
     * Constructor for objects of class Room
     */
    public Room (int id, String name, int size, Price price, Facility facility){
        super(id);
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
    }
}
