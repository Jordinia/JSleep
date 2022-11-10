package com.RizkiAwantaJordhieJSleepKM;

//package RizkiAwantaJordhieJSleepKM;

import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;


/**
 * Invoice class contains invoice information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (4 - PT4 - 06/10/2022)
 */
public class Invoice extends Serializable
{
    // instance variables - replace the example below with your own
    public int buyerId;
    public int renterId;
    //public String time;
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
    protected Invoice(int buyerId, int renterId)
    {
        //super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public Invoice(Account buyer, Renter renter)
    {
        //super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    /**
     * print method used for testcae
     *
     *
     * @return    the attributes of this class
     */
    public String print()
    {
        return "\nbuyerId= " + buyerId + "\nrenterId= " + renterId;
    }
}


