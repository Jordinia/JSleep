package RizkiAwantaJordhieJSleepKM;

//package RizkiAwantaJordhieJSleepKM;

/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    public static void main(String[] args){
    }
    public static int getHotelId(){
        return 0;
    }
    public static String getHotelName(){
        return "hotel";
    }
    public static boolean isDiscount(){
        return true;
    }
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount <= afterDiscount){
            return 0;
        }
        else {
            float diff = beforeDiscount - afterDiscount;
            return (diff/beforeDiscount)*100;
        }
    }
    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage >= 100.0f){
            discountPercentage = 100.0f;
        }
        return (int) (price - (price*(discountPercentage/100.0f)));
    }
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        if(discountedPrice <= 0){
            return 0;
        }
        float orgPrice = (100/(100-discountPercentage))*discountedPrice;
        return (int) orgPrice;
    }
    public static float getAdminFeePercentage(){
        return 0.05f;
    }
    public static int getAdminFee(int price){
        return (int) (price * getAdminFeePercentage());
    }
    public static int getTotalPrice(int price, int numberOfNight){
        return  ((price * numberOfNight) + getAdminFee(price));
    }
}
