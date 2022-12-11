package com.RizkiAwantaJordhieJSleepKM.dbjson;

/**
 * Parent class of Account, Room, Renter, Invoice, Voucher, and Payment.
 * Contains final variable id.
 * @author (Rizki Awanta Jordhie)
 * @version (2 - CS5 - 11/10/2022)
 */
import java.util.HashMap;

public class Serializable implements Comparable<Serializable> {

    /**
     * The unique ID of each object.
     */
    public final int id;

    /**
     * A map that stores the last assigned ID for each class that extends `Serializable`.
     */
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    /**
     * Creates a new `Serializable` object and assigns it a unique ID.
     */
    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter =  0;
        }
        else{
            counter +=1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    /**
     * Sets the last assigned ID for the given class that extends `Serializable`.
     *
     * @param clazz the class for which the last assigned ID will be set
     * @param id the last assigned ID for the given class
     * @return the previous value of the last assigned ID for the given class
     */
    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) { return mapCounter.put(clazz, id); }

    /**
     * Returns the last assigned ID for the given class that extends `Serializable`.
     *
     * @param clazz the class for which the last assigned ID will be returned
     * @return the last assigned ID for the given class
     */
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) { return mapCounter.get(clazz); }


    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}