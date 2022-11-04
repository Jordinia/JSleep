package RizkiAwantaJordhieJSleepKM;
//package RizkiAwantaJordhieJSleepKM;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Account class contains account information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (5 - PT6 - 04/11/2022)
 */
public class Account extends Serializable{

    public String name;
    public String email;
    public String password;

    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+(?:\\\\.[\\w!#$%&’*+/=?`{|}~^]+)*@(?:[a-zA-Z]+\\.)+[a-zA-Z]{2,6}$";
    public static final String REGEX_PASSWORD = "((?=\\S+$)(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]).{8,})";


    /**
     * Constructor for objects of class Account
     */
    public Account(String name, String email, String password){
        super();
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


