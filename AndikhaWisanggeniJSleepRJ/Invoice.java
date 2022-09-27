package AndikhaWisanggeniJSleepRJ;

public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public String time;
    
    protected Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.time = time;
        this.buyerId = buyer.id;
        this.renterId = renter.id;
    }
    
    public String print(){
        return "buyerId = " + this.buyerId + "\n" + "renterId = " + this.renterId + "\n" + "time = " + this.time;
    }
}
