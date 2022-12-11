package com.RizkiAwantaJordhieJSleepKM;

import java.util.ArrayList;

/**
 * Validator class
 *
 * @author (Rizki Awanta Jordhie)
 * @version (2 - PT4 - 06/10/2022)
 */
public class Validate {

    /**
     * Returns an `ArrayList` of the prices from the given array of `Price` objects that are either less than or greater than the given value, depending on the `less` parameter.
     *
     * @param list the array of `Price` objects to filter
     * @param value the value to compare the prices to
     * @param less a boolean indicating whether to return prices that are less than or greater than the given value
     * @return an `ArrayList` of the prices from the given array of `Price` objects that are either less than or greater than the given value, depending on the `less` parameter
     */

    public static ArrayList<Double> filter(Price[] list, int value, boolean less){
        ArrayList<Double> returned = new ArrayList<Double>();
        if(less){
            for (Price i : list) {
                if(i.price <= value){
                    returned.add(i.price);
                }
            }
        }

        else{
            for (Price i : list) {
                if(i.price > value){
                    returned.add(i.price);
                }
            }
        }
        return returned;
    }
}
