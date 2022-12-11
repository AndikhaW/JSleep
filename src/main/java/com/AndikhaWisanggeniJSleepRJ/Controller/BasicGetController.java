package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.Algorithm;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * This interface defines methods for performing basic `GET` requests for a serializable object `T`.
 *
 * @param <T> The type of serializable object to be returned by the `GET` requests.
 */
public interface BasicGetController <T extends Serializable> {
    public JsonTable<T> getJsonTable();

    /**
     * Handles a `GET` request to retrieve an object of type `T` by its id.
     *
     * @param id The id of the object to be retrieved.
     * @return The object of type `T` with the specified id, if it exists.
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }
    /**
     * Handles a `GET` request to retrieve a paginated list of objects of type `T`.
     *
     * @param page The page number to be retrieved.
     * @param pageSize The number of objects per page.
     * @return The paginated list of objects of type `T`.
     */
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @PathVariable int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred->true);
    }

}
