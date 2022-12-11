package com.RizkiAwantaJordhieJSleepKM.controller;


import com.RizkiAwantaJordhieJSleepKM.Account;
import com.RizkiAwantaJordhieJSleepKM.Algorithm;
import com.RizkiAwantaJordhieJSleepKM.Renter;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonAutowired;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the controller class for the `Account` entity.
 * It provides methods for handling HTTP requests related to accounts.
 *
 * @author Rizki Awanta Jordhie
 * @version (5 - PT9 - 04/11/2022)
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{

    /**
     * The regular expression pattern for validating email addresses.
     */
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";

    /**
     * The regular expression pattern for validating passwords.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";

    /**
     * The compiled regular expression pattern for validating passwords.
     */
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD) ;

    /**
     * The compiled regular expression pattern for validating email addresses.
     */
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    /**
     * The table of accounts.
     */
    @JsonAutowired(value=Account.class,filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;

    /**
     * Returns the table of accounts.
     *
     * @return The table of accounts.
     */
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * Handles a login request.
     *
     * @param email The email of the account.
     * @param password The password of the account.
     * @return The account if the login is successful, or `null` otherwise.
     */
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        final String hashedPassword = hashing(password);
        Account temp = Algorithm.<Account>find(accountTable,pred -> email.equals(pred.email) && hashedPassword.equals(pred.password));
        return temp;
    }

    /**
     * Handles a registration request.
     *
     * @param name The name of the account.
     * @param email The email of the account.
     * @param password The password of the account.
     * @return The created account if the registration is successful, or `null` otherwise.
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        boolean emailstatus  = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean passwordstatus = REGEX_PATTERN_PASSWORD.matcher(password).find();

        final String hashedPassword;
        if(emailstatus && passwordstatus && !name.isBlank()){
            hashedPassword = hashing(password);
            Account newAccount = new Account(name,email,hashedPassword);
            accountTable.add(newAccount);
            return newAccount;
        }
        else{
            return null;
        }
    }

    /**
     * Handles a request to register a renter for an account.
     *
     * @param id The ID of the account.
     * @param username The username of the renter.
     * @param address The address of the renter.
     * @param phoneNumber The phone number of the renter.
     * @return The registered renter if successful, or `null` otherwise.
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id,
                          @RequestParam String username,
                          @RequestParam String address,
                          @RequestParam String phoneNumber ){

        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username,phoneNumber,address);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    /**
     * Handles a request to top up the balance of an account.
     *
     * @param id The ID of the account.
     * @param balance The amount to top up.
     * @return `true` if the top up is successful, or `false` otherwise.
     */
    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id,
                  @RequestParam double balance ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Hashes the given password using the MD5 algorithm.
     *
     * @param password The password to hash.
     * @return The hashed password.
     */
    String hashing(String password){
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }
}