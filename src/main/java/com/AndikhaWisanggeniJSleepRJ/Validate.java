package com.AndikhaWisanggeniJSleepRJ;
import java.util.ArrayList;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
/**
 * A class that provides a method for filtering a list of Prices based on a given value and a boolean flag.
 *
 * @author Andikha Wisanggeni
 * @author JSleepRJ
 * @see Price
 * @see ArrayList
 * @see com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable
 */
public class Validate {
    /**
     * Filters a list of Prices based on the given value and the boolean flag.
     *
     * @param list  the list of Prices to be filtered
     * @param value the value to filter the list by
     * @param less  a boolean flag that determines whether the prices in the list should be less than or greater than the given value
     * @return an ArrayList of the prices that meet the criteria specified by the value and the boolean flag
     */
    public static ArrayList filter (com.AndikhaWisanggeniJSleepRJ.Price[] list, int value, boolean less){
        ArrayList filteredPrice = new ArrayList();
        if(less == true) {
            for (com.AndikhaWisanggeniJSleepRJ.Price iterator : list) {
                if(iterator.price <= value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        else{
            for (com.AndikhaWisanggeniJSleepRJ.Price iterator : list) {
                if(iterator.price > value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        return filteredPrice;
    }

}