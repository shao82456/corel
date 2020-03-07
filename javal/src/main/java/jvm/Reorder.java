package jvm;

import oracle.jrockit.jfr.Recording;
import pattern.single.Single1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Reordering {
    int x = 0, y = 0;

    public void writer() {
        /*try {
            Thread.sleep(1000*1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        x = 1;
        y = 2;
    }

    public void reader() {
        System.out.println(y);
        System.out.println(x);
    }
}

public class Reorder {
    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        Reordering r=new Reordering();
        es.execute(()->r.reader());
        es.execute(()->r.writer());

        es.shutdown();
    }
}
