package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonDBEngine;
//import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
//import java.util.Calendar;
import java.util.List;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import java.lang.*;

/**
 * The JSleep class is the entry point for the JSleep application.
 *
 * @author AndikhaWisanggeni
 * @see JsonDBEngine
 * @see SpringBootApplication
 */


@SpringBootApplication
//@RestController

public class JSleep
{

//    public static Room createRoom(){
//        Price price = new Price(100000, 5);
//        Room room = new Room(2, "hotel", 30, price, Facility.AC, City.DEPOK,"Jl. Margonda Raya");
//        return room;
//    }
//    /*class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }*/

    /**
     * The main method is the entry point for the JSleep application.
     *
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }


    /**
     * This method is used to test the JSleep application.
     *
     * @param room the command line arguments
     * @param city the command line arguments
     * @param start the command line arguments
     * @param end the command line arguments
     */
    public static List<Room> filterByCity(List<Room> room, String city, int start, int end){
        return Algorithm.<Room>paginate(room, start, end, i  -> i.city.toString().toLowerCase().contains(city.toLowerCase()));
    }
    /**
     * This method is used to test the JSleep application.
     *
     * @param room the command line arguments
     * @param price1 the command line arguments
     * @param price2 the command line arguments
     */
    public static List<Room> filterByPrice(List<Room> room, double price1, double price2){
        return Algorithm.<Room>collect(room, i -> i.price.price >= price1 && i.price.price <= price2);
    }


    /**
     * This method is used to test the JSleep application.
     *
     * @param room the command line arguments
     * @param accountId the command line arguments
     * @param id1 the command line arguments
     * @param id2 the command line arguments
     */
    public static List<Room> filterByAccountId(List<Room> room, int accountId, int id1, int id2){
        return Algorithm.<Room>paginate(room, id1, id2, i  -> i.accountId == accountId);
    }

}
