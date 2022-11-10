package com.RizkiAwantaJordhieJSleepKM;


import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;

/**
 * Account class contains account information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (5 - PT6 - 04/11/2022)
 */
public class Account extends Serializable
{
    public double balance;
    public Renter renter;
    public String name;
    public String email;
    public String password;
    public  static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public  static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public Account(String name,String email,String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }
    public String toString(){
        return "\nName= " + name + "\nEmail= " + email + "\nPassword= " + password;
    }
}
