package AndikhaWisanggeniJSleepRJ;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Payment extends Invoice
{
    public Calendar to;
    public Calendar from;
    public int roomId;
    
    public Payment(int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId){
        super(id, buyer, renter);
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
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
    

    
    
}
