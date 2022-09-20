package RizkiAwantaJordhieJSleepKM;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price {
    public double rebate;
    public double price;
    public int discount;

    public Price(double price){
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    public Price (double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    private double getDiscountedPrice(){
        if(discount >= 100){
            discount = 100;
        } else if (discount == 100) {
            return 0.0;
        }
        return (price - (price*(discount/100.0f)));
    }
    private double getRebatedPrice(){
        if(rebate > price){
            rebate = price;
        }
        return price - rebate;
    }

}
