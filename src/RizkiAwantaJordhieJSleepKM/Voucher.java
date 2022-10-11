package RizkiAwantaJordhieJSleepKM;


/**
 * Voucher class contains voucher information and regulates the usage of discount and rebate.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (3 - CS4 - 04/10/2022)
 */
public class Voucher extends Serializable implements FileParser {
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    /**
     * Constructor for objects of class Voucher
     */
    public Voucher (String name, int code, Type type, boolean used, double minimum, double cut){
        //super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
        this.used = used;
    }

    public boolean isUsed(){
        return this.used;
    }

    public boolean canApply(Price price){
        return ((price.price > this.minimum) && (used == false));
    }

    public double apply(Price price){
        this.used = true;

        if(this.type == Type.REBATE) {
            if(this.cut > price.price){
                this.cut = price.price;
            }
            return price.price - this.cut;
        } else {
            if (this.cut > 100) {
                this.cut = 100;
            }
            if (this.cut == 100){
                return 0.0;
            } else  {
                return price.price - (price.price*(this.cut/100.0f));
            }
        }
    }

    public Object write() {
        return null;
    }
    public boolean read(String content){
        return true;
    }

}


