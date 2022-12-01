package com.RizkiAwantaJordhieJSleepKM.controller;


import com.RizkiAwantaJordhieJSleepKM.Account;
import com.RizkiAwantaJordhieJSleepKM.Algorithm;
import com.RizkiAwantaJordhieJSleepKM.Renter;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonAutowired;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{


    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    @JsonAutowired(value=Account.class,filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD) ;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        final String hashedPassword = hashing(password);
        Account temp = Algorithm.<Account>find(accountTable,pred -> email.equals(pred.email) && hashedPassword.equals(pred.password));
        return temp;
    }

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