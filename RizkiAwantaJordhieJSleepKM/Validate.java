package RizkiAwantaJordhieJSleepKM;

import java.util.ArrayList;

/**
 * Validator class
 *
 * @author (Rizki Awanta Jordhie)
 * @version (1 - CS4 - 04/10/2022)
 */
public class Validate {
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList<Double> priceFilter = new ArrayList<Double>();
        int counter = 0;
        int countMore = 0;
        if (less == true){
            while (list[counter].price <= value){
                priceFilter.add(list[counter].price);
                counter++; //1 2 3 4 5
            }
        } else {
            while (counter < list.length){
                if (list[counter].price > value){
                    priceFilter.add(list[counter].price);
                    countMore++;
                }
                counter++; //1 2 3 4 5
            }
        }
        return priceFilter;
    }
}
