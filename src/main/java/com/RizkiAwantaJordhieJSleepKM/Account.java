package com.RizkiAwantaJordhieJSleepKM;

import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;

/**
 * Account class contains account information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (5 - PT6 - 04/11/2022)
 */
public class Account extends Serializable {

    public String name;
    public String email;
    public String password;
    public Renter renter;
    public double balance;

    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    /**
     * Constructor for objects of class Account
     */
    public Account(String name, String email, String password){
        super();
        this.balance = 0;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }

//    public Object write() {
//        return null;
//    }
//
//    public boolean read(String content){
//        return true;
//    }

    public String toString(){
        return "\nName= " + name + "\nEmail= " + email + "\nPassword= " + password;
    }

}


