package com.RizkiAwantaJordhieJSleepKM;


import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;

/**
 * Complaint class
 *
 * @author Rizki Awanta Jordhie
 * @version (1 - 29/09/2022)
 */
public class Complaint extends Serializable {
    public String desc;
    public String date;

    public Complaint(String date, String desc){
        //super(id);
        this.desc = desc;
        this.date = date;
    }

    public String toString(){
        return "\nDate= " + date + "\nDesc= " + desc;
    }
}
