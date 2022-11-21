package com.AndikhaWisanggeniJSleepRJ.Controller;

import com.AndikhaWisanggeniJSleepRJ.Algorithm;
import com.AndikhaWisanggeniJSleepRJ.Price;
import com.AndikhaWisanggeniJSleepRJ.Voucher;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonAutowired;
import com.AndikhaWisanggeniJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>{
    @JsonAutowired(value= Voucher.class,filepath = "src\\main\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
    ){
        Price price1 = new Price(price);
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.canApply(price1);
    }

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
