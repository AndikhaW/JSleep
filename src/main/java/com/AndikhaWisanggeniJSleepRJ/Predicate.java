package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
/**
 * This interface defines a generic predicate, which is a function that takes an object of type `T` as input
 * and returns a boolean value indicating whether the input satisfies some condition.
 *
 * @param <T> the type of the input to the predicate
 */
public interface Predicate <T> {
    public boolean predicate(T value);
}
