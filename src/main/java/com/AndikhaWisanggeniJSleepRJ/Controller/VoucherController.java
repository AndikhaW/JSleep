package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.Algorithm;
import com.AndikhaWisanggeniJSleepRJ.Price;
import com.AndikhaWisanggeniJSleepRJ.Voucher;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a Spring MVC controller for Voucher objects.
 * It contains several HTTP request mappings to handle requests related to Voucher objects.
 *
 * @author Andikha Wisanggeni
 * @version 1.0
 * @since 1.0
 */
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>{
    /**
     * This field is a JsonTable of Voucher objects, which is autowired with the JSON file at "src\\main\\json\\voucher.json"
     */
    @JsonAutowired(value= Voucher.class,filepath = "src\\main\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    /**
     * This method is a request mapping to handle HTTP GET requests for checking if a Voucher with a specified ID can be applied to a specified price.
     *
     * @param id the ID of the Voucher to be checked
     * @param price the price to which the Voucher will be applied
     * @return a boolean indicating whether the Voucher can be applied to the price
     */

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
    ){
        Price price1 = new Price(price);
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.canApply(price1);
    }

    /**
     * This method is a request mapping to handle HTTP GET requests for getting a list of all Vouchers.
     *
     * @return a list of all Vouchers
     */
    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        for(Voucher voucher : voucherTable){
            if(voucher.isUsed()){
                return Algorithm.<Voucher>paginate(voucherTable, page, pageSize, pred -> pred.isUsed());
            }
        }
        return null;
    }

    /**
     * This method is a request mapping to handle HTTP GET requests for getting a list of all Vouchers.
     *
     * @return a list of all Vouchers
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.isUsed();
    }

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }
}
