package com.RizkiAwantaJordhieJSleepKM.controller;


import java.util.List;
import com.RizkiAwantaJordhieJSleepKM.Algorithm;
import com.RizkiAwantaJordhieJSleepKM.dbjson.Serializable;
import com.RizkiAwantaJordhieJSleepKM.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a REST controller interface for implementing basic GET methods for objects that implement the Serializable interface.
 *
 * @author Rizki Awanta Jordhie, JSleepKM
 * @version (2 - PT7 - 10/11/2022)
 * @param <T> the type parameter for the objects that implement the Serializable interface
 */
@RestController
public interface BasicGetController <T extends Serializable> {

    /**
     * This method maps a GET request to the specified path with a path variable that represents the ID of the desired object.
     *
     * @param id the ID of the desired object
     * @return the object with the specified ID, or null if no such object was found
     */
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        T object = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return object;
    }

    /**
     * This abstract method returns a JsonTable object that contains the objects of type T.
     *
     * @return a JsonTable object that contains the objects of type T
     */
    public abstract JsonTable<T> getJsonTable();

    /**
     * This method maps a GET request to the specified path with request parameters for the page number and page size.
     *
     * @param page the page number of the desired page of results
     * @param pageSize the number of results per page
     * @return a list of objects that belong to the specified page, or an empty list if no such page exists
     */
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam  int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}