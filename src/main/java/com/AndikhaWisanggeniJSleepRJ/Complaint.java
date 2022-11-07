package com.AndikhaWisanggeniJSleepRJ;

public class Complaint extends com.AndikhaWisanggeniJSleepRJ.Serializable
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
