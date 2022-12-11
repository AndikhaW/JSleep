package com.AndikhaWisanggeniJSleepRJ;
import com.AndikhaWisanggeniJSleepRJ.dbjson.Serializable;
/**
 * Class representing a thread in a Java program.
 *
 * <p>This class extends the {@link Thread} class and overrides the {@link #run()} method
 * to print information about the current thread to the console.</p>
 *
 * @author Andikha Wisanggeni, JSleep, RJ
 * @version 1.0
 */
public class ThreadingObject extends Thread{
    public ThreadingObject(String name){
        super(name);
        start();
    }
    @Override
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
        System.out.println("ID Thread " + Thread.currentThread().getId());
    }
}
