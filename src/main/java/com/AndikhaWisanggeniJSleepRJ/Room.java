package com.AndikhaWisanggeniJSleepRJ;
import java.util.ArrayList;
import java.util.Date;

public class Room extends com.AndikhaWisanggeniJSleepRJ.Serializable //implements FileParser
{
    public int size;
    public com.AndikhaWisanggeniJSleepRJ.Price price;
    public com.AndikhaWisanggeniJSleepRJ.Facility facility;
    public String name;
    public String address;
    public com.AndikhaWisanggeniJSleepRJ.BedType bedType;
    public com.AndikhaWisanggeniJSleepRJ.City city;
    public ArrayList<Date> booked;
    public int accountId;

    
    public Room(int accountId, String name, int size, com.AndikhaWisanggeniJSleepRJ.Price price, com.AndikhaWisanggeniJSleepRJ.Facility facility, com.AndikhaWisanggeniJSleepRJ.City city, String address){
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
