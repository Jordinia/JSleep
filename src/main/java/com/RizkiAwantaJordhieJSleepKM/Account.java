package com.RizkiAwantaJordhieJSleepKM;


import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;

/**
 * The Account class contains account information and methods for validating
 * email and password strings.
 *
 * @author Rizki Awanta Jordhie
 * @version (5 - PT6 - 04/11/2022)
 */
public class Account extends Serializable
{
    public double balance;
    public Renter renter;
    public String name;
    public String email;
    public String password;

    /** The regular expression for validating email addresses. */
    public  static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    /** The regular expression for validating passwords. */
    public  static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * Constructs a new Account object with the given name, email, and password.
     * The account balance is initialized to 0.
     *
     * @param name the name of the account holder
     * @param email the email address associated with the account
     * @param password the password for the account
     */

    /**
     * Returns true if the email and password associated with this account
     * match the given email and password.
     *
     * @param email the email to validate
     * @param password the password to validate
     * @return true if the email and password are valid, false otherwise
     */
    public Account(String name,String email,String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    /**
     * Returns true if the email and password associated with this account
     * match the given email and password.
     *
     * @return true if the email and password are valid, false otherwise
     */
    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }

    /**
     * Returns a string representation of this Account object.
     *
     * @return a string containing the name, email, and password of this Account
     */
    public String toString(){
        return "\nName= " + name + "\nEmail= " + email + "\nPassword= " + password;
    }
}
