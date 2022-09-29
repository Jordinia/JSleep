package RizkiAwantaJordhieJSleepKM;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (3 - 29/09/2022)
 */
public class Price {
//    public double rebate;
    public double price;
    public double discount;

    public Price(double price){
        this.price = price;
        this.discount = 0;
        //this.rebate = 0;
    }
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
        //this.rebate = 0; comment from CS2 PT
    }
    public String toString(){
        return "\nPrice= " + price + "\nDiscount= " + discount;
    }
//    public Price (double price, double rebate){ CS2 PT
//        this.price = price;
//        this.rebate = rebate;
//        this.discount = 0;
//    }
//    private double getDiscountedPrice(){
//        if (discount >= 100) {
//            return 0.0;
//        } else  {
//            return price - (price*(discount/100.0f));
//        };
//    }
//    private double getRebatedPrice(){
//        if(rebate > price){
//            rebate = price;
//        }
//        return price - rebate;
//    }

}
