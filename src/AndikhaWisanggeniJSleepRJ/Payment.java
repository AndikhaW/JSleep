package AndikhaWisanggeniJSleepRJ;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;
    
    public Payment(int buyerId, int renterId, int roomId){
        super(buyerId, renterId);
        this.from = from;//Calendar.getInstance();
        this.to = to;//Calendar.getInstance();
        //this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }
    
    public Payment(Account buyer, Renter renter, int roomId){
        super(buyer, renter);
        this.from = from;//Calendar.getInstance();
        this.to = to;//Calendar.getInstance();
        //this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }
    
    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String timeTo = SDFormat.format(from.getTime());
        return "Formatted Date = " + timeTo;
    }
    
    public String getDuration(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String durFrom = SDFormat.format(from.getTime());
        String durTo   = SDFormat.format(to.getTime());
        return durFrom + " - " + durTo;
    }
    public String print(){
        return "roomId = " + this.roomId  + "from = " + this.from  + "to = " + this.to;
    }
    
    public int getRoomId(){
        return this.roomId;
    }
    
    public static boolean availability(Date from, Date to, Room room){
        if(room.booked.isEmpty()){
            return true;
        }
        for(Date i : room.booked){
            if(i.after(from) && i.before(to) || i.equals(from)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean makeBooking(Date from, Date to, Room room){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(from);
        String bookFrom = SDFormat.format(from.getTime());
        String bookTo = SDFormat.format(to.getTime());
        if(availability(from, to, room)){
            while(from.before(to)){
                room.booked.add(from);
                cal.setTime(from);
                cal.add(Calendar.DATE, 1);
                from = cal.getTime();
            }
            return true;
        } else {
            return false;
        }
     }
}
