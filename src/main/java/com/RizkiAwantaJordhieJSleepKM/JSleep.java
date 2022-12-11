package com.RizkiAwantaJordhieJSleepKM;

import java.util.List;

import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonDBEngine;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * JSleep main.
 *
 * @author Rizki Awanta Jordhie
 * @version (7 - PT6 - 04/11/2022)
 */
@SpringBootApplication
public class JSleep
{

    /**
     * The main method of the JSleep application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args){
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }

    /**
     * Creates a new Room instance.
     *
     * @return the created Room instance
     */
    public static Room createRoom(){
        Price price = new Price(100000,5);
        Room room = new Room(1, "Hotel", 30,price,Facility.AC,City.DEPOK,"Jalan Margonda Raya");
        return room;
    }

    /**
     * Filters a list of rooms based on the city.
     *
     * @param list the list of rooms to filter
     * @param search the search query for the city
     * @param page the page number
     * @param pageSize the page size
     * @return the filtered list of rooms
     */
    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room->room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }

    /**
     * Filters a list of rooms based on the price.
     *
     * @param list the list of rooms to filter
     * @param minPrice the minimum price
     * @param maxPrice the maximum price
     * @return the filtered list of rooms
     */
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        if (maxPrice == 0){
            return Algorithm.<Room>collect(list, p -> (p.price.price >= minPrice));
        }
        return Algorithm.<Room>collect(list, p -> (p.price.price <= maxPrice) && (p.price.price >= minPrice));
    }

    /**
     * Filters a list of rooms based on the account ID.
     *
     * @param list the list of rooms to filter
     * @param accountId the account ID
     * @param page the page number
     * @param pageSize the page size
     * @return the filtered list of rooms
     */
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room->(room.accountId == accountId));
    }
}


