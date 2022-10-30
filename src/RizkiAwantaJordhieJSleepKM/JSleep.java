package RizkiAwantaJordhieJSleepKM;
/**
 * JSleep.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (5 - PT4 - 06/10/2022)
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

public class JSleep
{
    public static int getHotelId(){
        return 0;
    }
    public static String getHotelName(){
        return "hotel";
    }
    public static boolean isDiscount(){
        return true;
    }
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount <= afterDiscount){
            return 0;
        }
        else {
            float diff = beforeDiscount - afterDiscount;
            return (diff/beforeDiscount)*100;
        }
    }
    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage >= 100.0f){
            discountPercentage = 100.0f;
        }
        return (int) (price - (price*(discountPercentage/100.0f)));
    }
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        if(discountedPrice <= 0){
            return 0;
        }
        float orgPrice = (100/(100-discountPercentage))*discountedPrice;
        return (int) orgPrice;
    }
    public static float getAdminFeePercentage(){
        return 0.05f;
    }
    public static int getAdminFee(int price){
        return (int) (price * getAdminFeePercentage());
    }
    public static int getTotalPrice(int price, int numberOfNight){
        return  ((price * numberOfNight) + getAdminFee(price*numberOfNight));
    }
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args){
        String filepath= "C:\\Users\\Rizky Awanta Jordhie\\Documents\\All-Files\\TUGAS\\UI\\2-Pembelajaran\\3-Kuliah\\Materi x Buku\\Semester 3\\Object Oriented Programming\\Praktikum OOP\\Code\\JSleep\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states :");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //        ArrayList<Room> RoomSerialized = new ArrayList<>();
//
//        for(int i = 0; i <  5; i++){
//            RoomSerialized.add(i, createRoom());
//            System.out.println(RoomSerialized.get(i).toString());
//        }
//        Room RoomA = JSleep.createRoom();
//        Room RoomB = JSleep.createRoom();
//        System.out.println("Membuat booking dari tanggal 15 hingga 18");
//        Date start = Date.valueOf("2022-8-15");
//        Date end = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start, end,RoomA));
//        System.out.println("Membuat booking dari tanggal 15 hingga 18");
//        Date start2 = Date.valueOf("2022-8-18");
//        Date end2 = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start2, end2,RoomA));
//        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
//        Date start3 = Date.valueOf("2022-8-18");
//        Date end3 = Date.valueOf("2022-8-20");
//        System.out.println(Payment.makeBooking(start3, end3,RoomB));
//        System.out.println("Membuat booking dari tanggal 20 hingga 15");
//        Date start4 = Date.valueOf("2022-8-20");
//        Date end4 = Date.valueOf("2022-8-15");
//        System.out.println(Payment.makeBooking(start4, end4,RoomA));
    }
    public static Room createRoom(){
        Price price = new Price(100000,5);
        Room room = new Room("Hotel", 30,price,Facility.AC,City.DEPOK,"Jalan Margonda Raya");
        return room;
    }

}


