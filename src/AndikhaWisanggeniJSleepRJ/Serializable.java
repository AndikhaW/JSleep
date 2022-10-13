package AndikhaWisanggeniJSleepRJ;
import java.util.HashMap;

public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    protected Serializable (){
        Integer counter = mapCounter.get(this.getClass());
        if (counter == null) {
            counter = 0;
        }else {
            mapCounter.put(this.getClass(), counter + 1);
            counter++;
        }
        this.id = counter;
        mapCounter.put(this.getClass(), counter);
    }
    public int compareTo(Serializable serial){
        return this.id - serial.id;
    }
    public boolean equals(Object object){
        if(object instanceof Serializable){
            return this.id == ((Serializable)object).id;
        }
        return false;
    }
    public boolean equals(Serializable serial) {
        return this.id == serial.id;
    }
    public static <T> Integer getClosingId(Class<T> klas){
        return mapCounter.get(klas);
    }

    public static <T> Integer setClosingId(Class<T> klas, int id){
        return mapCounter.replace(klas, id);
    }
}
