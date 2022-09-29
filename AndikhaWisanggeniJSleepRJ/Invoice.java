package AndikhaWisanggeniJSleepRJ;

public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public String time;
    
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
    public RoomRating rating;
    public PaymentStatus status;
    protected Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.time = time;
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print(){
        return "buyerId = " + this.buyerId + "\n" + "renterId = " + this.renterId + "\n" + "time = " + this.time;
    }
}
