package AndikhaWisanggeniJSleepRJ;
import java.util.Iterator;
import java.util.Arrays;

public class Algorithm {
    private Algorithm(){

    }
    public static <T> int count(Iterator<T> iterator, T value){
        int i;
        i = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(value)){
                i++;
            }
        }
        return i;
    }
    public static <T> int count(T[] array, T value){
        return count(Arrays.asList(array).iterator(), value);
    }
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        int i;
        i = 0;
        for(T type : iterable) {
            if (pred.predicate(type)) {
                i++;
            }else{
                return i;
            }
        }
        return i;
    }
    public static <T> int count(T[] array, Predicate<T> pred){
        return count(Arrays.asList(array).iterator(), pred);
    }
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int i;
        i = 0;
        while(iterator.hasNext()){
            if(pred.predicate(iterator.next())){
                i++;
            }
        }
        return i;
    }
    public static <T> int count(Iterable<T> iterable, T value){
        return count(iterable.iterator(), value);
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }
    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T type = iterator.next();
            if(pred.predicate(type)) {
                return true;
            }
        }
        return false;
    }
    public static <T> T find(T[] array, Predicate<T> pred){
        for(T type:array){
            if(pred.predicate(type)){
                return type;
            }else {
                return null;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        for(T type:iterable){
            if(pred.predicate(type)){
                return type;
            }
        }
        return null;
    }
    public static <T> T find(T[] array, T value){
        final Predicate<T> pred = value::equals;
        return find(array, pred);
    }
    public static <T> T find(Iterable<T> iterable, T value){
        final Predicate<T> pred = value::equals;
        return find(iterable, pred);
    }
    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            T type = iterator.next();
            if(pred.predicate(type)){
                return type;
            }
            return null;
        }
        return null;
    }
}
