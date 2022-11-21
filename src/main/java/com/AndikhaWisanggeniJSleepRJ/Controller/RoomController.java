package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.*;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value= Room.class,filepath = "src\\main\\json\\room.json")

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
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(account == null){
            return null;
        }
        Room room = new Room(accountId, name, size, new Price(price), facility, city, address);
        roomTable.add(room);
        return room;

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
