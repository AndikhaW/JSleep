package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
import com.AndikhaWisanggeniJSleepRJ.Payment;
import org.springframework.web.bind.annotation.RequestParam;

public class PaymentController {
    public static JsonTable<Payment> paymentTable;
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ){
        return null;
        //return new Payment(buyerId, renterId, from, to);
    }
    public boolean submit(int id){
        return true;
    }
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    public boolean accept(int id){
        return true;
    }
    public boolean cancel(int id){
        return true;
    }
}
