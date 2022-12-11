package com.RizkiAwantaJordhieJSleepKM;


/**
 * This class represents the price of an item and its associated discount.
 *
 * @author Rizki Awanta Jordhie
 * @version 3 - 29/09/2022
 */
public class Price {
//    public double rebate;
    /** The price of the item */
    public double price;

    /** The discount applied to the item */
    public double discount;

    /**
     * Constructs a new `Price` object with the given price and no discount.
     *
     * @param price the price of the item
     */
    public Price(double price){
        this.price = price;
        this.discount = 0;
    }

    /**
     * Constructs a new `Price` object with the given price and discount.
     *
     * @param price the price of the item
     * @param discount the discount applied to the item
     */
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }

    /**
     * Returns a string representation of this `Price` object in the form "Price= X\nDiscount= Y".
     *
     * @return a string representation of this `Price` object
     */
    public String toString(){
        return "\nPrice= " + price + "\nDiscount= " + discount;
    }}
