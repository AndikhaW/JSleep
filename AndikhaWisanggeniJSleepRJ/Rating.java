package AndikhaWisanggeniJSleepRJ;

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
