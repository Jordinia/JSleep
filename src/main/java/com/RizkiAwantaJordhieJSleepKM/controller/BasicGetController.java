package com.RizkiAwantaJordhieJSleepKM.controller;

import com.RizkiAwantaJordhieJSleepKM.Predicate;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;
import com.RizkiAwantaJordhieJSleepKM.Algorithm;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/controller")
public interface BasicGetController<T extends Serializable> {

    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        final Predicate<T> idFilter = pred -> (id == pred.id);
        return Algorithm.find(getJsonTable(), idFilter);
    }

    @GetMapping(value ="/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}
