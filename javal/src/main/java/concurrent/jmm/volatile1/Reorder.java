package concurrent.jmm.volatile1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: shaoff
 * Date: 2020/5/23 18:31
 * Package: concurrent.jmm.volatile1
 * Description:
 *
 * volatile 重排续
 */
public class Reorder {
    static  int a=1;
    static  int b=2;
    static void test1(){
        Runnable t1=new Runnable() {
            @Override
            public void run() {
                a=5;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b=6;
                int c=a+1;
//                System.out.println(a+":"+b);
            }
        };
        Runnable t2=new Runnable() {
            @Override
            public void run() {
                while (b!=6){
                    System.out.println(b);
                }
                assert a==5; //may be wrong
                System.out.println("done");
            }
        };
        ExecutorService es= Executors.newCachedThreadPool();
        es.execute(t2);
        es.execute(t1);
    }

    public static void main(String[] args) {
        test1();
    }
}
