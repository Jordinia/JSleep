package com.RizkiAwantaJordhieJSleepKM;

//package RizkiAwantaJordhieJSleepKM;


import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Payment class contains payment information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (3 - PT4 - 06/10/2022)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    public Date to;
    public Date from;
    private int roomId;
    /**
     * Constructor for objects of class Payment
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    /* CS4
    public String getDuration(){
        SimpleDateFormat dateDuration = new SimpleDateFormat("dd MMMMM yyyy");
        to.add(Calendar.DATE, 2);
        return dateDuration.format(this.from.getTime()) + " - " + dateDuration.format(this.to.getTime());
    }*/
    public int getRoomId() {
        return this.roomId;
    }
    public String getTime(){
        SimpleDateFormat dateTime = new SimpleDateFormat("dd MMMMM yyyy");
        return  "Formatted Date = " + dateTime.format(this.time.getTime());
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


