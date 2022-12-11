package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.Account;
import com.AndikhaWisanggeniJSleepRJ.Algorithm;
import com.AndikhaWisanggeniJSleepRJ.Renter;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.*;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * The `AccountController` class is a REST controller responsible for handling requests related to accounts.
 *
 * @author AndikhaWisanggeni
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    /**
     * A regular expression that defines the format of a valid password. A valid password must
     * contain at least one lowercase letter, one uppercase letter, and one digit, and must
     * be at least eight characters long.
     */

    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    @JsonAutowired(value=Account.class,filepath = "src/main/java/com/json/account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD) ;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);


    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        String encryptedPassword = null;

        /**
         * Encrypt the password using the SHA-256 algorithm.
         */
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            encryptedPassword = sb.toString();

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        String finalEncryptedPassword = encryptedPassword;
        Account temp = Algorithm.<Account>find(accountTable, pred -> email.equals(pred.email) && finalEncryptedPassword.equals(pred.password));
        return temp;
    }

    /**
     * This method handles HTTP POST requests to the `/account/register` endpoint.
     * It creates a new account with the given username, password, and email.
     *
     * @param name the username of the new account
     * @param password the password of the new account
     * @param email the email of the new account
     * @return the newly created account
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        String encryptedPassword = null;
        boolean emailstatus = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean passwordstatus = REGEX_PATTERN_PASSWORD.matcher(password).find();

        /**
         * Encrypt the password using the SHA-256 algorithm.
         */
        if(passwordstatus && emailstatus && !name.isBlank()){
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] bytes = md.digest(password.getBytes());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++){
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
                }
                encryptedPassword = sb.toString();

            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            accountTable.add(new Account(name,email,encryptedPassword));
            return new Account(name, email, encryptedPassword);
        }
        else{
            return null;
        }

    }

    /**
     * This method handles HTTP GET requests to the `/account` endpoint.
     * It returns a list of all accounts.
     *
     * @return a list of all accounts
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address,
                          @RequestParam String phoneNumber ){

        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

}