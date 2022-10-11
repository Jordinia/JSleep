package RizkiAwantaJordhieJSleepKM;
//package RizkiAwantaJordhieJSleepKM;


import java.util.ArrayList;
import java.util.Date;

/**
 * Account class contains room details information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (5 - PT4 - 06/10/2022)
 */
public class Room extends Serializable implements FileParser{
    public int size;
    public String name;
    public String address;
    public Facility facility;
    public BedType bedType;
    public Price price;
    public City city;

    public ArrayList<Date> booked;

    /**
     * Constructor for objects of class Room
     */
    public Room (String name, int size, Price price, Facility facility, City city, String address){
        //super(id);
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
        this.booked = new ArrayList<Date>();
    }

    public Object write() {
        return null;
    }
    public boolean read(String content){
        return true;
    }
    public String toString(){
        return "\nId= " + id + "\nName= " + name +
                "\nSize= " + size + "\nAddress= " + address +
                "\nFacility= " + facility + "\nBedType= " + bedType +
                "\nCity= " + city + "\nPrice= " + price;
    }


}


