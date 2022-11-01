package RizkiAwantaJordhieJSleepKM;
/**
 * JSleep main.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (6 - CS6 - 01/11/2022)
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
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        System.out.println(testRegex.validate());
        try{
            String filepath = "C:\\Users\\Rizky Awanta Jordhie\\Documents\\All-Files\\TUGAS\\UI\\2-Pembelajaran\\3-Kuliah\\Materi x Buku\\Semester 3\\Object Oriented Programming\\Praktikum OOP\\Code\\JSleep\\src\\RizkiAwantaJordhieJSleepKM\\json\\randomRoomList.json";

            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByAccountId(tableRoom, 1, 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
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
        return Algorithm.<Room>collect(list, p -> (p.price.price <= maxPrice) && (p.price.price >= minPrice));
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room->(room.accountId == accountId));
    }
//    public static int getHotelId(){
//        return 0;
//    }
//    public static String getHotelName(){
//        return "hotel";
//    }
//    public static boolean isDiscount(){
//        return true;
//    }
//    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
//        if(beforeDiscount <= afterDiscount){
//            return 0;
//        }
//        else {
//            float diff = beforeDiscount - afterDiscount;
//            return (diff/beforeDiscount)*100;
//        }
//    }
//    public static int getDiscountedPrice(int price, float discountPercentage){
//        if(discountPercentage >= 100.0f){
//            discountPercentage = 100.0f;
//        }
//        return (int) (price - (price*(discountPercentage/100.0f)));
//    }
//    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
//        if(discountedPrice <= 0){
//            return 0;
//        }
//        float orgPrice = (100/(100-discountPercentage))*discountedPrice;
//        return (int) orgPrice;
//    }
//    public static float getAdminFeePercentage(){
//        return 0.05f;
//    }
//    public static int getAdminFee(int price){
//        return (int) (price * getAdminFeePercentage());
//    }
//    public static int getTotalPrice(int price, int numberOfNight){
//        return  ((price * numberOfNight) + getAdminFee(price*numberOfNight));
//    }
//    class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }


}


