package com.RizkiAwantaJordhieJSleepKM;

//package RizkiAwantaJordhieJSleepKM;


import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Payment class contains payment information.
 *
 * @author Rizki Awanta Jordhie
 * @version 3 - PT4 - 06/10/2022
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Date to;
    public Date from;
    private int roomId;

    /**
     * Constructor for a Payment instance with the given buyer and renter IDs, room ID, and dates.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     * @param roomId the ID of the room
     * @param from the starting date of the payment
     * @param to the end date of the payment
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a Payment instance with the given buyer and renter accounts, room ID, and dates.
     *
     * @param buyer the buyer's account
     * @param renter the renter
     * @param roomId the ID of the room
     * @param from the starting date of the payment
     * @param to the end date of the payment
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the room ID of this Payment.
     *
     * @return the room ID of this Payment
     */
    public int getRoomId() {
        return this.roomId;
    }

    public static boolean makeBooking(Date from, Date to, Room room){
        if(availability(from, to, room)){
            while (from.before(to)){
                room.booked.add(from);
                Calendar temp = Calendar.getInstance();
                temp.setTime(from);
                temp.add(Calendar.DATE, 1);
                from = temp.getTime();
            }
            return true;
        } else {
            return false;
        }
    }
    public static boolean availability(Date from, Date to, Room room){
        if(room.booked.isEmpty()){
            return true;
        } else if(from.after(to) || to.before(from) || from.equals(to)){
            return false;
        } else {
            for (Date temp : room.booked) {
                if (from.equals(temp)) {
                    return false;
                } else if(from.before(temp) && to.after(temp)){
                    return false;
                }
            }
            return true;
        }
//        if(room.booked.isEmpty()){ PT4
//            return true;
//        } else {
//            if(from.after(to) || to.before(from)){
//                return false;
//            }
//            Date temp;
//            for (int i = 0; i <= room.booked.size(); i++){
//                temp = room.booked.get(i);
//                if(temp.after(from) && temp.before(to) || temp.equals(from)){
//                    return false;
//                }
//            }
//            return true;
//        }
    }

    /**
     * print method used for testcae
     *
     *
     * @return    the attributes of this class
     */
    public String print()
    {
        return "\nroomId= " + roomId + "\nto= " + to + "\nfrom= " + from;
    }
    
}


