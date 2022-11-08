package com.AndikhaWisanggeniJSleepRJ;
import java.util.ArrayList;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
public class Validate {
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