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

import java.util.function.Predicate;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

            for (Account account : accountTable){
                if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                    return null;
                }
            }
        return new Account(name, email, password);
    }

    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password){
//        final Predicate<T> loginPred = pred -> pred.;
        Account account = Algorithm.<Account>find(accountTable,  pred -> (pred.email.equals(email)) && (pred.password.equals(password)));
        return account;
    }

    @PostMapping("/{id}/registerStore")
    Renter registerRenter(@PathVariable int id,
                          @RequestParam String name,
                          @RequestParam String address,
                          @RequestParam String phoneNumber) {

        for(Account account : accountTable) {
            if(account.id == id && account.renter == null) {

                Renter registRenter = new Renter(name, address, phoneNumber);
                account.renter = registRenter;
                return registRenter;

            }
        }

        return null;

    }
    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id,
                  @RequestParam double balance) {

        for(Account account : accountTable) {
            if(account.id == id) {
                account.balance += balance;
                return true;
            }
        }

        return false;

    }

    @JsonAutowired(filepath = "json/Account.json", value = Account.class)
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {

        return accountTable;

    }

//    @Override
//    @GetMapping("/{id}")
//    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}
