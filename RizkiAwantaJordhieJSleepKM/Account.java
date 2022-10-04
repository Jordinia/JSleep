package RizkiAwantaJordhieJSleepKM;
//package RizkiAwantaJordhieJSleepKM;


/**
 * Account class contains account information.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (4 - CS4 - 04/10/2022)
 */
public class Account extends Serializable implements FileParser{
    public String name;
    public String email;
    public String password;
    /**
     * Constructor for objects of class Account
     */
    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Object write() {
        return null;
    }
    public boolean read(String content){
        return true;
    }

    public String toString(){
        return "\nName= " + name + "\nEmail= " + email + "\nPassword= " + password;
    }

}


