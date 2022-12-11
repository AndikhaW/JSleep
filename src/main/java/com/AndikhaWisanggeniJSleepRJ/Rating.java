package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
/**
 * This class represents a Rating, which contains information about the total and count of ratings.
 */
public class Rating
{
    private long total;
    private long count;
    
    public Rating(){
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }

    /**
     * Returns a string representation of this Rating.
     *
     * @return a string representation of this Rating
     */
    public double getAverage(){
        this.count = count;
        this.total = total;
        if(count <= 0){
            count = 1;
        }
        return total/count;
    }
    
    public String toString(){
        return "Count   = " + this.count + "\n" + "Total    = " + this.total;
    }
}
