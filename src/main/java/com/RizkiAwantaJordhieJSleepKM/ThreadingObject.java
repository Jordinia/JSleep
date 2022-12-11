package com.RizkiAwantaJordhieJSleepKM;

/**
 * The `ThreadingObject` class is a simple implementation of the `Thread` class
 * that prints a message when it is started.
 *
 * @author Rizki Awanta Jordhie
 * @version 1 - PT6 - 04/11/2022
 */
public class ThreadingObject extends Thread{
    /**
     * Constructs a new `ThreadingObject` instance with the given name.
     *
     * @param name the name of the thread
     */
    public ThreadingObject(String name){
        super(name);
        this.start();
    }

    /**
     * Prints a message when the thread is started.
     */
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}
