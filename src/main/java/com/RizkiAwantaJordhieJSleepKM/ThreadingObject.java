package com.RizkiAwantaJordhieJSleepKM;

/**
 * ThreadingObject class used for threading.
 *
 * @author (Rizki Awanta Jordhie)
 * @version (1 - PT6 - 04/11/2022)
 */
public class ThreadingObject extends Thread{
    public ThreadingObject(String name){
        super(name);
        this.start();
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}