package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;

public class Price
{
    public double price;
    public double discount;
    
    public Price(double price){
        this.price = price;
    }
    
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public String toString(){
        return "Price = " + this.price + "\n" + "Discount = " + this.discount + "\n";
    }
    /*
    public double price;
    public int discount;
    public double rebate;
    
    public Price(double price){
        this.price = price;
        discount = 0;
        rebate = 0;
    }
    
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        rebate = 0;
    }
    
    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        discount = 0;
    }
    
    private double getDiscountedPrice(){
        this.discount = discount;
        this.price = price;
        if(discount >= 100){
            return 0;
        }
        else{
            return price - (price * (discount/100));
        }
    }
    
    private double getRebatedPrice(){
        this.price = price;
        this.rebate = rebate;
        if(price == rebate){
            return price;
        }
        else{
            return price - rebate;
        }
    }*/
}
