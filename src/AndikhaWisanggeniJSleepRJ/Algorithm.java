package AndikhaWisanggeniJSleepRJ;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Algorithm {
    private Algorithm() {

    }

    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> iterator = iterable.iterator();
        return collect(iterator, value);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> iterator = iterable.iterator();
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(T[] array, T value) {
        return collect(Arrays.asList(array), value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        final List<T> t = new ArrayList<>();
        while (iterator.hasNext()) {
            T type = iterator.next();
            if (pred.predicate(type)) {
                t.add(type);
            }else{
                return t;
            }
        }
        return t;
    }

    public static <T> int count(Iterator<T> iterator, T value) {
        int i;
        i = 0;
        while (iterator.hasNext()) {
            if (iterator.next().equals(value)) {
                i++;
            }
        }
        return i;
    }

    public static <T> int count(T[] array, T value) {
        return count(Arrays.asList(array).iterator(), value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        int i;
        i = 0;
        for (T type : iterable) {
            if (pred.predicate(type)) {
                i++;
            } else {
                return i;
            }
        }
        return i;
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        return count(Arrays.asList(array).iterator(), pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int i;
        i = 0;
        while (iterator.hasNext()) {
            if (pred.predicate(iterator.next())) {
                i++;
            }
        }
        return i;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        return count(iterable.iterator(), value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T type = iterator.next();
            if (pred.predicate(type)) {
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        for (T type : array) {
            if (pred.predicate(type)) {
                return type;
            } else {
                return null;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for (T type : iterable) {
            if (pred.predicate(type)) {
                return type;
            }
        }
        return null;
    }

    public static <T> T find(T[] array, T value) {
        final Predicate<T> pred = value::equals;
        return find(array, pred);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterable, pred);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T type = iterator.next();
            if (pred.predicate(type)) {
                return type;
            }
            return null;
        }
        return null;
    }

    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return paginate(iterator, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        final List<T> t = new ArrayList<>();
        int ctr = 0;
        while (iterator.hasNext()) {
            T type = iterator.next();
            if (pred.predicate(type)) {
                if (ctr >= page * pageSize && ctr < (page + 1) * pageSize) {
                    t.add(type);
                }else{
                    return null;
                }
                ctr++;
            }
        }
        return t;
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> iterator = iterable.iterator();
        return paginate(iterator, page, pageSize, pred);
    }
}
