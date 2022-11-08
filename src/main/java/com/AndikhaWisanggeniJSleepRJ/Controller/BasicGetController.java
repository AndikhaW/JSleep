package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.Algorithm;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BasicGetController <T extends Serializable> {
    public JsonTable<T> getJsonTable();
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }

    @GetMapping("/{page}")
    public default List<T> getPage(
            @RequestParam int page,
            @PathVariable int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred->true);
    }

}
