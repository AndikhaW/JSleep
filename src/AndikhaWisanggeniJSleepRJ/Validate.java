package AndikhaWisanggeniJSleepRJ;
import java.util.ArrayList;

public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList harga = new ArrayList();
        if(less){
            for(Price i : list){
                if(i.price <= value){
                    harga.add(i.price);
                }
            }
        }else{
            for(Price i : list){
                if(i.price > value){
                    harga.add(i.price);
                }
            }
        }return harga;
    }
}
