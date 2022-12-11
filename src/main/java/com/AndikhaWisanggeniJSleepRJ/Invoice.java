package com.AndikhaWisanggeniJSleepRJ;
//import java.util.Date;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;

/**
 * The Invoice class represents an invoice for a rental transaction.
 *
 * @author AndikhaWisanggeniJSleepRJ
 * @see Serializable
 * @see RoomRating
 * @see PaymentStatus
 */

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
        FAILED, WAITING, SUCCESS
    }
    
    public RoomRating rating;
    public PaymentStatus status;

    /**
     * This is a protected constructor for the Invoice class.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     */
    protected Invoice(int buyerId, int renterId){
        //super(id);
        //this.time = new Date();//Date.getInstance();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * This is a constructor for the Invoice class that takes in an Account object and a Renter object.
     *
     * @param buyer the Account object of the buyer
     * @param renter the Renter object of the renter
     */

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
