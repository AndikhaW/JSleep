package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;

/**
 * Created by Andikha Wisanggeni on 4/26/2017.
 * This class is used to store the data of the hotel room
 * @author Andikha Wisanggeni
 * @version 0.1
 * @since 2017-04-26
 */
public class Account extends Serializable //implements FileParser
{
    /**
     * The name of the hotel
     */
    public String name;
    public String email;
    public String password;
    public double balance;
    public Renter renter;
    //REGEX_EMAIL = local@domain
    //REGEX_EMAIL = local only alphabet and number, no special character, no whitespace
    //REGEX_EMAIL = domain only alphabet, no number, no gmail, no yahoo, no whitespace, the end of domain must be .
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z.][a-zA-Z]$";
    //REGEX_PASSWORD   = 1 capital, 1 lowercase, 1 number, 8 character, no whitespace
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";


    public Account(String name, String email, String password){
        //super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean validate(){
        if (this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "Name    = " + this.name + "\n" + "Email     = " + this.email + "\n";
    }
    
//    public Object write (){
//        return null;
//    }

//    public boolean read(String string){
//        return false;
//    }
//
//    public String name;
//    public String email;
//    public String password;
//    public Account(){
//    }
}
