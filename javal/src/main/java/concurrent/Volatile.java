package concurrent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Volatile {
    static volatile int turn=0;
    public static void main(String[] args) throws FileNotFoundException {
//        System.setOut(new PrintStream("out.log"));
        Thread t1=new Thread(new HelloTask());t1.setName("HelloTh");
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t2=new Thread(new WorldTask());t2.setName("WorldTH");
//        Thread t3=new Thread(new JavaTask());t3.setName("JavaTH");

        t1.start();
        t2.start();
//        t3.start();

        System.setOut(System.out);
        System.out.println("done");
    }
}

class HelloTask implements Runnable{
    int i=0;

    @Override
    public void run() {
        while (true) {
            i=0;
            Volatile.turn=1;
            while (Volatile.turn==1){
                i+=1;
            };
            System.out.println(i+" "+Thread.currentThread().getName()+" hello");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
class WorldTask implements Runnable{
    int i=0;
    @Override
    public void run() {
        while (true) {
            i=0;
            Volatile.turn = 0;
            while (Volatile.turn == 0) {
                i+=1;
            };
            System.out.println(i+" "+Thread.currentThread().getName() + " world");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class JavaTask implements Runnable{
    int i;
    @Override
    public void run() {
        while (true) {
            i=0;
            while (Volatile.turn!=2){
                i+=1;
            };
            System.out.println(i+" "+Thread.currentThread().getName()+" java");
            Volatile.turn=0;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
