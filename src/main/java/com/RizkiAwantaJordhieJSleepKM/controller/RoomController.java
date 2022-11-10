package com.RizkiAwantaJordhieJSleepKM.controller;

import com.RizkiAwantaJordhieJSleepKM.*;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonAutowired;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
    @JsonAutowired(value= Room.class,filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.id == id);
    }

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
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }
}
