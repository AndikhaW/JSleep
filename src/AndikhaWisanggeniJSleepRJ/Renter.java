package AndikhaWisanggeniJSleepRJ;

public class Renter extends Serializable
{
    public int phoneNumber = 0;
    public String address = "";
    public String username;
    
    public Renter (String username){
        //super(id);
        this.username = username;
    }
    public Renter (String username, String address){
        //super(id);
        this.username = username;
        this.address = address;
    }
    public Renter (String username, int phoneNumber){
        //super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    public Renter (String username, int phoneNumber, String address){
        //super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
