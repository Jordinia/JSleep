package RizkiAwantaJordhieJSleepKM;

import java.util.ArrayList;

/**
 * Validator class
 *
 * @author (Rizki Awanta Jordhie)
 * @version (2 - PT4 - 06/10/2022)
 */
public class Validate {
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
