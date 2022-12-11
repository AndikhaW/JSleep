package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
/**
 * The Renter class represents a renter in a rental transaction.
 *
 * @author AndikhaWisanggeniJSleepRJ
 * @see Serializable
 */
public class Renter extends Serializable
{
    /** The phone number of the renter */
    public String phoneNumber = "";

    /** The address of the renter */
    public String address = "";

    /** The username of the renter */
    public String username;

    /** The regular expression for a valid username */
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{5,20}$";

    /** The regular expression for a valid phone number */
    public static final String REGEX_PHONE = "[0-9]{9,12}";

    /**
     * This is the constructor for the Renter class.
     *
     * @param username the username of the renter
     * @param phoneNumber the phone number of the renter
     * @param address the address of the renter
     */
    public Renter (String username, String phoneNumber, String address){
        //super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * This method checks if the Renter object's username and phone number fields match their respective regular expressions.
     *
     * @return true if the username and phone number are valid, false otherwise
     */
    public boolean validate(){
        if(this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE)){
            return true;
        }
        else{
            return false;
        }
    }

}
