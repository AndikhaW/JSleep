package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.*;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value= Payment.class,filepath = "src/main/json/account.json")
    public static JsonTable<Payment> paymentTable;
    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        //Account with id matching buyerId (into accountTable)
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        //Room with id matching roomId (into roomTable)
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);
        //count total price (use double price from room)
//        Invoice invoice = new Invoice(room.price, buyer, room);
//        Payment payment = new Payment(buyerId, room, from, to);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);

        return null;
        //return new Payment(buyerId, renterId, from, to);
    }
    @PostMapping("/submit")
    public boolean submit(int id){
        return true;
    }
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    @PostMapping("/{id}/accept")
    public boolean accept(int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if(payment != null){
            if(payment.status == Invoice.PaymentStatus.PENDING){
                payment.status = Invoice.PaymentStatus.ACCEPTED;
                return true;
            }
            return true;
        }
        return false;
       // return true;
    }
    @PostMapping("/{id}/cancel")
    public boolean cancel(int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if(payment != null){
            if(payment.status == Invoice.PaymentStatus.ACCEPTED){
                return false;
            }
        }
        return true;
        //return true;
    }
}
