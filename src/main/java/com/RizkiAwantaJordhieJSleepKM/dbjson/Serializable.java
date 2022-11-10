package com.RizkiAwantaJordhieJSleepKM.dbjson;


import java.util.HashMap;

/**
 * Parent class of Account, Room, Renter, Invoice, Voucher, and Payment.
 * Contains final variable id.
 * @author (Rizki Awanta Jordhie)
 * @version (2 - CS5 - 11/10/2022)
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    /**
     * Constructor for objects of class Serializable
     */
    protected Serializable(){
        Integer idCount = mapCounter.get(getClass());
        if (idCount == null){
            idCount = 0;
        } else {
            idCount++;
            mapCounter.put(getClass(), idCount);
        }
        this.id = idCount;
    }
    public static <T extends Serializable> Integer setClosingId(Class<T> obj, int data){
        return mapCounter.put(obj,data);
    }
    public static <T extends Serializable> int getClosingId(Class<T> inpClass){
        return mapCounter.get(inpClass);
    }

    //@Override
    public int compareTo(Serializable temp){
        return Integer.compare(this.id, temp.id);
    }

    public boolean equals(Object temp){
        return (temp instanceof Serializable) && (((Serializable) temp).id == this.id);
    }
    public boolean equals(Serializable temp){
        return temp.id == id;
    }
}
