package AndikhaWisanggeniJSleepRJ;
import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable //implements FileParser
{
    public int size;
    public Price price;
    public Facility facility;
    public String name;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;
    public int accountId;

    
    public Room(int accountId, String name,int size, Price price, Facility facility, City city, String address){
        //super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<Date>();
        this.accountId = accountId;
    }
    
    public String toString(){
      return "Name      = " + this.name + "\n" + "Size    = " + this.size + "\n" + "Price     = " + this.price + "\n" + "Facility = " + this.facility + "\n" + "City      = " + this.city + "\n" + "Address   = " + this.address + "\n" + "id =" + this.accountId + "\n";
    }
    
//    public Object write (){
//        return null;
//    }
//    public boolean read(String string){
//        return false;
//    }
}
