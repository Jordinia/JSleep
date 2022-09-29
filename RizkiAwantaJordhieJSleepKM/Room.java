package RizkiAwantaJordhieJSleepKM;

/**
 * Account class contains room details information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (3 - 29/09/2022)
 */
public class Room extends Serializable {
    public int size;
    public String name;
    public String address;
    public Facility facility;
    public BedType bedType;
    public Price price;
    public City city;


    /**
     * Constructor for objects of class Room
     */
    public Room (int id, String name, int size, Price price, Facility facility, City city, String address){
        super(id);
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
    }

    public String toString(){
        return "\nId= " + id + "\nName= " + name +
                "\nSize= " + size + "\nAddress= " + address +
                "\nFacility= " + facility + "\nBedType= " + bedType +
                "\nCity= " + city + "\nPrice= " + price;
    }


}
