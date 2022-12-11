package com.AndikhaWisanggeniJSleepRJ;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;

/**
 * This class represents a Payment, which extends the {@link com.AndikhaWisanggeniJSleepRJ.Invoice} class.
 * It contains information about the buyer, renter, and room associated with the payment, as well as the dates
 * the payment covers.
 */
public class Payment extends com.AndikhaWisanggeniJSleepRJ.Invoice {

    private int roomId;
    public Date from;
    public Date to;



    /**
     * Constructs a new Payment with the given buyer and renter ids and room id.
     *
     * @param buyerId the id of the buyer associated with this payment
     * @param renterId the id of the renter associated with this payment
     * @param roomId the id of the room associated with this payment
     */
    public Payment(int buyerId, int renterId, int roomId ) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a new Payment with the given buyer and renter ids and room id.
     *
     * @param buyer the id of the buyer associated with this payment
     * @param renter the id of the renter associated with this payment
     * @param roomId the id of the room associated with this payment
     * @param from the date the payment starts
     * @param to the date the payment ends
     */
    public Payment(com.AndikhaWisanggeniJSleepRJ.Account buyer, com.AndikhaWisanggeniJSleepRJ.Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }



    public int getRoomId() {
        return roomId;
    }


    /**
     * Returns a string representation of this Payment.
     *
     * @return a string representation of this Payment
     */
    public static boolean makeBooking(Date from, Date to, com.AndikhaWisanggeniJSleepRJ.Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    /**
     * Makes a booking for the given dates and room, if the room is available for those dates.
     *
     * @param from the start date of the booking
     * @param to the end date of the booking
     * @param room the room to book
     * @return true if the booking was successful, false if the room is not available for the given dates
     */
    public static boolean availability(Date from, Date to, com.AndikhaWisanggeniJSleepRJ.Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

//    public String getTime(){
//        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date' = dd MMMM yyyy");
//        String currTime = SDFormat.format(time.getTime());
//        return currTime;
//    }

    /**
     * Returns a string representation of this Payment.
     *
     * @return a string representation of this Payment
     */
    @Override
    public String print(){
        return "Payment{" +
                "roomId=" + roomId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}
