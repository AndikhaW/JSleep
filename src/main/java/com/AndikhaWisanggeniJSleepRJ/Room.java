package com.AndikhaWisanggeniJSleepRJ;
import java.util.ArrayList;
import java.util.Date;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
public class Room extends Serializable //implements FileParser
{
    public int size;
    public com.AndikhaWisanggeniJSleepRJ.Price price;
    public ArrayList<Facility> facility = new ArrayList<>();
    public String name;
    public String address;
    public com.AndikhaWisanggeniJSleepRJ.BedType bedType;
    public com.AndikhaWisanggeniJSleepRJ.City city;
    public ArrayList<Date> booked;
    public int accountId;

    
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType){
        //super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility.addAll(facility);
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<Date>();
        this.accountId = accountId;
        this.bedType = bedType;
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
