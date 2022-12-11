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
    // instance variables
    public int buyerId;
    public int renterId;
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
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     */
    protected Invoice(int buyerId, int renterId)
    {
        //super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Constructs an Invoice with the given buyer and renter.
     *
     * @param buyer the buyer's account
     * @param renter the renter
     */
    public Invoice(Account buyer, Renter renter)
    {
        //super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Returns a string representation of this Invoice.
     *
     * @return a string containing the attributes of this Invoice
     */
    public String print()
    {
        return "\nbuyerId= " + buyerId + "\nrenterId= " + renterId;
    }
}


