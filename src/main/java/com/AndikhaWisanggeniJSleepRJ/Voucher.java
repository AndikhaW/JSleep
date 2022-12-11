package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
public class Voucher extends Serializable //implements FileParser
{
    public String name;
    public boolean used;
    public int code;
    public com.AndikhaWisanggeniJSleepRJ.Type type;
    public double minimum;
    public double cut;

    /**
     * This is the constructor for the Voucher class.
     *
     * @param name the name of the voucher
     * @param code the code of the voucher
     * @param type the type of the voucher
     * @param minimum the minimum price of the voucher
     * @param cut the cut of the voucher
     */
    public Voucher (String name, int code, com.AndikhaWisanggeniJSleepRJ.Type type, boolean used, double minimum, double cut){
        //super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }
    public Object write (){
        return null;
    }
    public boolean read(String string){
        return false;
    }
    /*
    public Type type;
    public double cut;
    public String   name;
    public int code;
    public double minimum;
    public boolean used;
    public Voucher(String name, int code, Type type, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }
    */
    public boolean canApply(Price price){
        if(price.price > minimum && used == false){
            return true;
        }else{
            return false;
        }
    }


    /**
     * This method applies the voucher to the given price.
     *
     * @param price the price to apply the voucher to
     * @return the price after the voucher has been applied
     */
    public double apply(com.AndikhaWisanggeniJSleepRJ.Price price){
        this.used = true;
        if(this.type == com.AndikhaWisanggeniJSleepRJ.Type.DISCOUNT){
            if(this.cut >= 100){
                return 0;
            }
            else{
                return price.price - (price.price * (this.cut/100));
            }
        }else{
            if(price.price <= this.cut){
                price.price = this.cut;
            }
                return price.price - this.cut;
        }
    }
    public boolean isUsed(){
        return this.used;
    }
}
