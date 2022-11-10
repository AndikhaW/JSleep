package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.*;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value= Room.class,filepath = "src/main/json/room.json")

    public static JsonTable<Room> roomTable;

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
        Price price1 = new Price(price);
        return new Room(accountId, name, size, price1, facility, city, address);
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(roomTable, page, pageSize, pred -> pred.id == id);
    }

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }
}
