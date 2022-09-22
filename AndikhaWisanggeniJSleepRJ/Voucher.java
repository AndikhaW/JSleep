package AndikhaWisanggeniJSleepRJ;

public class Voucher
{
    public Type type;
    public double cut;
    public String name;
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
    
    public boolean canApply(Price price){
        if(price.price > minimum && used == false){
            return true;
        }else{
            return false;
        }
    }
    
    public double apply(Price price){
        this.used = true;
        if(this.type == Type.DISCOUNT){
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
