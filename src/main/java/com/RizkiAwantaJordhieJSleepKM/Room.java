package com.RizkiAwantaJordhieJSleepKM;

import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

/**
 * The `Room` class contains information about a room available for rent.
 *
 * @author Rizki Awanta Jordhie
 * @version 5 - PT4 - 06/10/2022
 */
public class Room extends Serializable {
    public int size;
    public int accountId;
    public String name;
    public String address;
    public Facility facility;
    public BedType bedType;
    public Price price;
    public City city;

    public ArrayList<Date> booked;

    /**
     * Constructs a new `Room` object with the given information.
     *
     * @param accountId the ID of the account that owns the room
     * @param name the name of the room
     * @param size the size of the room
     * @param price the price of the room
     * @param facility the facilities available in the room
     * @param city the city where the room is located
     * @param address the address of the room
     */
    public Room (int accountId, String name, int size, Price price, Facility facility, City city, String address){
        //super(id);
        this.accountId = accountId;
        this.size = size;
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
        this.booked = new ArrayList<Date>();
    }

    /**
     * Serializes the `Room` object as a string.
     *
     * @return the serialized string representation of the `Room` object
     */
    public Object write() {
        return null;
    }

    /**
     * Deserializes a `Room` object from the given string.
     *
     * @param content the string to deserialize
     * @return `true` if the deserialization was successful, `false` otherwise
     */
    public boolean read(String content){
        return true;
    }

    /**
     * Returns a string representation of the `Room` object.
     *
     * @return a string with the `Room` object's information
     */
    public String toString(){
        return "\nId= " + id + "\nName= " + name +
                "\nSize= " + size + "\nAddress= " + address +
                "\nFacility= " + facility + "\nBedType= " + bedType +
                "\nCity= " + city + "\nPrice= " + price;
    }

}


