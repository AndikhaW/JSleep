package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;

/**
 * This class represents a Price, which contains information about the price and discount associated with an item.
 */
public class Price
{
    public double price;
    public double discount;
    
    public Price(double price){
        this.price = price;
    }

    /**
     * Constructs a new Price with the given price and discount.
     *
     * @param price the price of the item
     * @param discount the discount of the item
     */
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public String toString(){
        return "Price = " + this.price + "\n" + "Discount = " + this.discount + "\n";
    }

}
