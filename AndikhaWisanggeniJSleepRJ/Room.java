package AndikhaWisanggeniJSleepRJ;

public class Room extends Serializable
{
    public int size;
    public Price price;
    public Facility facility;
    public String name;
    public String address;
    public BedType bedType;
    public City city;
    
    public Room(int id, String name,int size, Price price, Facility facility, City city, String address){
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }
    
    public String toString(){
      return "Name      = " + this.name + "\n" + "Size      = " + this.size + "\n" + "Price     = " + this.price + "\n" + "Facility = " + this.facility + "\n" + "City      = " + this.city + "\n" + "Address   = " + this.address + "\n";
    }
    
}
