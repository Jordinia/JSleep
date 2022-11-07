package com.RizkiAwantaJordhieJSleepKM;


/**
 * Write a description of class Rating here.
 *
 * @author (your name)
 * @version (2 - 29/09/2022)
 */
public class Rating {
    private long total;
    private long count;

    public Rating(){
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    public double getAverage(){
        if(this.count == 0){
            return 0.0;
        }
        return this.total / this.count;
    }
    public long getCount(){
        return this.count;
    }
    public long getTotal(){
        return this.total;
    }
    public String toString(){
        return "\nTotal= " + total + "\nCount= " + count;
    }
}
