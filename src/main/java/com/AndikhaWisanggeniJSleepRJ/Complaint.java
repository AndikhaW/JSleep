package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
public class Complaint extends Serializable
{
    public String desc;
    public String date;
    
    public Complaint(String date, String desc){
        //super(id);
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        return "ID      = " + id + "\n" +"Date  = " + this.date + "\n" + "Desc  = " + this.desc + "\n";
    }
}
