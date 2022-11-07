package com.AndikhaWisanggeniJSleepRJ;
import java.util.Date;

public class Invoice extends com.AndikhaWisanggeniJSleepRJ.Serializable
{
    public int buyerId;
    public int renterId;
    public Date time;
    
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
    
    public RoomRating rating;
    public PaymentStatus status;
    protected Invoice(int buyerId, int renterId){
        //super(id);
        this.time = new Date();//Date.getInstance();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(com.AndikhaWisanggeniJSleepRJ.Account buyer, com.AndikhaWisanggeniJSleepRJ.Renter renter){
        //super(id);
        this.time = new Date();//Calendar.getInstance();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print(){
        return "buyerId = " + this.buyerId  + "renterId = " + this.renterId  + "time = " + this.time;
    }
}