package com.AndikhaWisanggeniJSleepRJ;

public class Renter extends com.AndikhaWisanggeniJSleepRJ.Serializable
{
    public String phoneNumber = "";
    public String address = "";
    public String username;
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{5,20}$";
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    
    public Renter (String username, String phoneNumber, String address){
        //super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public boolean validate(){
        if(this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE)){
            return true;
        }
        else{
            return false;
        }
    }
//    public Renter (String username, String address){
//        //super(id);
//        this.username = username;
//        this.address = address;
//    }
//    public Renter (String username, String phoneNumber){
//        //super(id);
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//    }
//    public Renter (String username, String phoneNumber, String address){
//        //super(id);
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//    }
}
