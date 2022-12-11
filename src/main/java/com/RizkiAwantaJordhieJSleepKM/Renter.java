package com.RizkiAwantaJordhieJSleepKM;

import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a renter and contains their information.
 *
 * @author Rizki Awanta Jordhie
 * @version 3 - CS6 - 01/11/2022
 */
public class Renter extends Serializable {

    /** The username of the renter */
    public String username;

    /** The phone number of the renter */
    public String phoneNumber;

    /** The address of the renter */
    public String address = "";

    /** A regular expression that matches valid usernames */
    public static final String REGEX_NAME = "^[A-Z]{1}\\w{4,20}$";

    /** A regular expression that matches valid phone numbers */
    public static final String REGEX_PHONE = "^\\d{9,12}$";

    /**
     * Constructs a new `Renter` object with the given username, phone number, and address.
     *
     * @param username the username of the renter
     * @param phoneNumber the phone number of the renter
     * @param address the address of the renter
     */
    public Renter(String username, String phoneNumber, String address) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Returns `true` if the renter's username and phone number are valid, `false` otherwise.
     * A username is valid if it matches the regular expression defined by the `REGEX_NAME` field.
     * A phone number is valid if it matches the regular expression defined by the `REGEX_PHONE` field.
     *
     * @return `true` if the renter's username and phone number are valid, `false` otherwise
     */
    public boolean validate(){
        Pattern name = Pattern.compile(this.REGEX_NAME);
        Pattern phone= Pattern.compile(this.REGEX_PHONE);
        Matcher nameMatcher = name.matcher(this.username);
        Matcher phoneMatcher = phone.matcher(this.phoneNumber);

        return nameMatcher.find() && phoneMatcher.find();
    }
}
