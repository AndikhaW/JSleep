package com.AndikhaWisanggeniJSleepRJ;
//import java.util.Date;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;

    public Invoice() {

    }
    //public Date time;
    
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }
    public enum PaymentStatus{
        FAILED, WAITING, ACCEPTED, PENDING, SUCCESS
    }
    
    public RoomRating rating;
    public PaymentStatus status;
    protected Invoice(int buyerId, int renterId){
        //super(id);
        //this.time = new Date();//Date.getInstance();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(Account buyer, Renter renter){
        //super(id);
        //this.time = new Date();//Calendar.getInstance();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print(){
        return "buyerId = " + this.buyerId  + "renterId = " + this.renterId ;
    }
}
