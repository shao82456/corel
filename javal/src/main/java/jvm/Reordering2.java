package jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Reordering2 {
    String b=new String("...B");
    int d=1;
    {
        System.out.println("init begin");
        try {
            Thread.sleep(500);
            b="...B!";
            d+=3;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    String c=new String("...C");

    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        AtomicReference<Reordering2> r2 = new AtomicReference<>();

        Thread t2=new Thread(()->{
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            r2.get();
            System.out.println("geted");
        });
        Thread t1=new Thread(()->{
            try {
                Thread.sleep(1000*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2.set(new Reordering2());
            t2.interrupt();
        });
        t1.start();t2.start();
        es.shutdown();
    }
}
