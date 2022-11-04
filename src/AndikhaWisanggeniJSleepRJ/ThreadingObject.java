package AndikhaWisanggeniJSleepRJ;

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
