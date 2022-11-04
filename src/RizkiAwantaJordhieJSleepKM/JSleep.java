package RizkiAwantaJordhieJSleepKM;
/**
 * JSleep main.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (7 - PT6 - 04/11/2022)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class JSleep
{

    public static void main(String[] args){
//        Account testRegex = new Account("JOR","jordhie@gmail.com","Abcd12345");
//        Account testRegexfalse = new Account("JOR FALSE"," jordhie@ui.ac.id","Abcd12345");
//        System.out.println(testRegex.validate());
//        System.out.println(testRegexfalse.validate());
        try {
            String filepath = "src\\RizkiAwantaJordhieJSleepKM\\json\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<Account>(Account.class, filepath);
            Account account = new Account("name","email","password");
            tableAccount.add(account);
            tableAccount.writeJson();
            System.out.print(tableAccount);
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
        for (int i = 0; i < 10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }
        // CS6
//        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
//        System.out.println(testRegex.validate());
//        try{
//            String filepath = "C:\\Users\\Rizky Awanta Jordhie\\Documents\\All-Files\\TUGAS\\UI\\2-Pembelajaran\\3-Kuliah\\Materi x Buku\\Semester 3\\Object Oriented Programming\\Praktikum OOP\\Code\\JSleep\\src\\RizkiAwantaJordhieJSleepKM\\json\\randomRoomList.json";
//
//            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
//            List<Room> filterTableRoom = filterByAccountId(tableRoom, 1, 0, 5);
//            filterTableRoom.forEach(room -> System.out.println(room.toString()));
//        }
//        catch (Throwable t){
//            t.printStackTrace();
    }

    public static Room createRoom(){
        Price price = new Price(100000,5);
        Room room = new Room(1, "Hotel", 30,price,Facility.AC,City.DEPOK,"Jalan Margonda Raya");
        return room;
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room->room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        if (maxPrice == 0){
            return Algorithm.<Room>collect(list, p -> (p.price.price >= minPrice));
        }
        return Algorithm.<Room>collect(list, p -> (p.price.price <= maxPrice) && (p.price.price >= minPrice));
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room->(room.accountId == accountId));
    }
}


