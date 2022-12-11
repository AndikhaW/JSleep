package com.AndikhaWisanggeniJSleepRJ.dbjson;
import java.util.HashMap;

/**
 * Class representing a voucher that can be used to apply discounts or rebates to prices.
 *
 * This class extends the {@link Serializable} class and implements the  interface.
 * It has fields for the voucher name, code, type, minimum amount, and discount or rebate amount.
 * It also has methods for checking whether the voucher can be applied to a given price, applying the
 * voucher to a price, and checking if the voucher has been used.
 *
 * @author Andikha Wisanggeni
 * @version 1.0
 */
public class Serializable implements Comparable<Serializable>{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter =  0;
        }
        else{
            counter +=1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) { return mapCounter.put(clazz, id); }

    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) { return mapCounter.get(clazz); }

    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}