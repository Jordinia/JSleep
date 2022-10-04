package RizkiAwantaJordhieJSleepKM;
/**
 * JSleep.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (4 - CS4 - 04/10/2022)
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
        Payment testPayment = new Payment(2,2,2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for(int i=0;i < unfilteredArray.length; i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length; i++){
            System.out.println(unfilteredArray[i].price);
        }
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000, true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000, false));
        /* PT3
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
                Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
         */

        /* CS3
        Payment testRoom = new Payment(1, 1, 1, "time", 1, "from", "to");
        Invoice testInvoice = new Invoice(2,2,2, "time");
        System.out.println(testRoom.print());;
        System.out.println(testInvoice.print());
        */
        
        /* CS2
        Room tes = createRoom();
        System.out.println(tes.name);
        System.out.println(tes.size);
        System.out.println(tes.price.price);
        System.out.println(tes.facility);
        */
       
    }
//    public static Room createRoom(){ CS2
//        return new Room(1, "hotel", 30, new Price(100000, 5), Facility.AC);
//    }

}

