package com.RizkiAwantaJordhieJSleepKM.controller;

import com.RizkiAwantaJordhieJSleepKM.*;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonAutowired;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is a class for the Room objects and contains methods for managing rooms.
 * It also implements the BasicGetController interface to provide basic GET methods.
 *
 * @author Rizki Awanta Jordhie, JSleepKM
 * @version (2 - PT7 - 10/11/2022)
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    /**
     * The table of payments.
     */
    @JsonAutowired(value= Room.class,filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;

    /**
     * Returns a paginated list of rooms rented by a user with the given ID.
     *
     * @param id the ID of the user who rented the rooms
     * @param page the page number of the paginated list to return
     * @param pageSize the number of items per page
     * @return a paginated list of rooms rented by the user with the given ID
     */
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.id == id);
    }

    /**
     * Creates a new room and adds it to the `roomTable`.
     *
     * @param accountId the ID of the user who will rent the room
     * @param name the name of the room
     * @param size the size of the room
     * @param price the price of the room
     * @param facility the facility provided by the room
     * @param city the city where the room is located
     * @param address the address of the room
     * @return the created room, or `null` if the user with the given ID is not a renter
     */
    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
            ){
        Account temp = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(temp == null){
            return null;
        }
        Room room = new Room(accountId, name, size, new Price(price), facility, city, address);
        roomTable.add(room);
        return room;
    }

    /**
     * Returns a paginated list of all rooms.
     *
     * @param page the page number of the paginated list to return
     * @param pageSize the number of items per page
     * @return a paginated list of all rooms
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    /**
     * Returns the table containing Room information.
     *
     * @return the table containing Room information
     */
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }
}
