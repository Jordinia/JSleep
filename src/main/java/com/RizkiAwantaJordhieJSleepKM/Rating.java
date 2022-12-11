package com.RizkiAwantaJordhieJSleepKM;


/**
 * This class represents a rating and stores the total and count of ratings.
 *
 * @author Rizki Awanta Jordhie
 * @version 2 - 29/09/2022
 */
public class Rating {
    /** The total of all ratings */
    private long total;

    /** The number of ratings */
    private long count;

    /**
     * Constructs a new `Rating` object with 0 total and 0 count.
     */
    public Rating(){
        this.total = 0;
        this.count = 0;
    }

    /**
     * Inserts a new rating.
     *
     * @param rating the rating to insert
     */
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }

    /**
     * Returns the average of all ratings.
     *
     * @return the average of all ratings, or 0 if there are no ratings
     */
    public double getAverage(){
        if(this.count == 0){
            return 0.0;
        }
        return this.total / this.count;
    }

    /**
     * Returns the total of all ratings.
     *
     * @return the total of all ratings
     */
    public long getTotal(){
        return this.total;
    }

    /**
     * Returns the number of ratings.
     *
     * @return the number of ratings
     */
    public long getCount(){
        return this.count;
    }

    /**
     * Returns a string representation of this `Rating` object in the form "Total= X\nCount= Y".
     *
     * @return a string representation of this `Rating` object
     */
    public String toString(){
        return "\nTotal= " + total + "\nCount= " + count;
    }}
