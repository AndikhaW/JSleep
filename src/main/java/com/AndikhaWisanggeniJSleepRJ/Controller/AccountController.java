package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.Account;
import com.AndikhaWisanggeniJSleepRJ.Renter;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;
import java.util.*;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z.][a-zA-Z]$";;
    public static JsonTable<Account> accountTable;
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final String REGEX_EMAIL = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")

    @Override
    public JsonTable<Account> getJsonTable() {
        return null;
    }

    //@PostMapping("/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        for(Account account : accountTable){
            if(account.id == id){
                return new Renter( username, address, phoneNumber);
            }
        }
        return null;
    }
    //@PostMapping("/TopUp")
    Boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    ){
        for(Account account : accountTable){
            if(account.id == id){
                balance += balance;
                return true;
            }
        }
        return false;
        //return true;
    }
    //@PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        return new Account(name, email, password);
    }

    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        return null;
        //return new Account(email, password);
    }
}
