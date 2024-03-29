package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.*;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The `PaymentController` class is a RESTful web service controller that provides endpoints
 * for creating, updating, and retrieving payment information.
 *
 * @author AndikhaWisanggeni
 * @version 1.0
 * @since 1.0
 */

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    /**
     * The `paymentTable` field is a static field that stores the payment table.
     */
    @JsonAutowired(value= Payment.class,filepath = "src/main/java/com/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    /**
     * The `getJsonTable` method is a getter for the `paymentTable` field.
     *
     * @return The `paymentTable` field.
     */
    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        int duration = toDate.getDate() - fromDate.getDate();
        double balance = room.price.price * duration;


        if (buyer != null && room != null) {
            if (buyer.balance >= room.price.price && Payment.availability(fromDate, toDate, room)) {
                Payment newPayment = new Payment(buyerId, renterId, roomId);
                buyer.balance = buyer.balance - room.price.price;
                newPayment.status = Invoice.PaymentStatus.WAITING;
                newPayment.makeBooking(fromDate, toDate, room);

                paymentTable.add(newPayment);
                return newPayment;
            }
        }

        return null;
        //return new Payment(buyerId, renterId, from, to);
    }
//    @PostMapping("/{id}/submit")
//    public boolean submit(@PathVariable int id){
//        return true;
//    }
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    /**
     * The `update` method is a method that updates the payment information.
     *
     * @param id The id of the payment to be updated.
     */
    @PostMapping("/{id}/accept")
    public boolean accept(int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if(payment != null){
            if(payment.status == Invoice.PaymentStatus.WAITING){
                payment.status = Invoice.PaymentStatus.SUCCESS;
                return true;
            }
            //return true;
        }
        return false;
       // return true;
    }

    /**
     * The `update` method is a method that updates the payment information.
     *
     * @param id The id of the payment to be updated.
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.getRoomId());
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);

        if(payment != null){
            if(payment.status == Invoice.PaymentStatus.WAITING){
                payment.status = Invoice.PaymentStatus.FAILED;
                buyer.balance = buyer.balance + room.price.price;
                return true;
            }
        }
        return false;
        //return true;
    }
}
