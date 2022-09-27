package RizkiAwantaJordhieJSleepKM;

//package RizkiAwantaJordhieJSleepKM;
//package RizkiAwantaJordhieJSleepKM;

/**
 * JSleep.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (3 - 27/09/2022)
 */
public class JSleep
{
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
        return  ((price * numberOfNight) + getAdminFee(price*numberOfNight));
    }
    public static void main(String[] args){
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2,2,2, "");
        System.out.println(testRoom.print());;
        System.out.println(testInvoice.print());
        
        /*Room tes = createRoom();
        System.out.println(tes.name);
        System.out.println(tes.size);
        System.out.println(tes.price.price);
        System.out.println(tes.facility);
        */
       
    }
    public static Room createRoom(){
        return new Room(1, "hotel", 30, new Price(100000, 5), Facility.AC);
    }

}
