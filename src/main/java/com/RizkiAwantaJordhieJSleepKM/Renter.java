package com.RizkiAwantaJordhieJSleepKM;

import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Renter class contains renter information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (3 - CS6 - 01/11/2022)
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String username;
    public String phoneNumber;
    public String address = "";
    public static final String REGEX_NAME = "^[A-Z]{1}\\w{4,20}$";
    public static final String REGEX_PHONE = "^\\d{9,12}$";
    public Renter(String username, String phoneNumber, String address)
    {
//        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public boolean validate(){
        Pattern name = Pattern.compile(this.REGEX_NAME);
        Pattern phone= Pattern.compile(this.REGEX_PHONE);
        Matcher nameMatcher = name.matcher(this.username);
        Matcher phoneMatcher = phone.matcher(this.phoneNumber);

        return nameMatcher.find() && phoneMatcher.find();
    }
}
