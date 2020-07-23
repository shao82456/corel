package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: shaoff
 * Date: 2020/6/28 18:08
 * Package: atomic
 * Description:
 */
public class RaceCondition {
    static final int max=10;
    static AtomicInteger count=new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        es.execute(()->{
            for(int i=0;i<10;i++){
                if(count.incrementAndGet()>max){
                    System.out.println("reset");
                    count.set(0);
                }
            }
        });
        es.execute(()->{
            for(int i=0;i<10;i++){
                if(count.incrementAndGet()>max){
                    System.out.println("reset");
                    count.set(0);
                }
            }
        });
        es.execute(()->{
            for(int i=0;i<10;i++){
                if(count.incrementAndGet()>max){
                    System.out.println("reset");
                    count.set(0);
                }
            }
        });
        es.execute(()->{
            for(int i=0;i<10;i++){
                if(count.incrementAndGet()>max){
                    System.out.println("reset");
                    count.set(0);
                }
            }
        });
        es.execute(()->{
            for(int i=0;i<10;i++){
                if(count.incrementAndGet()>max){
                    System.out.println("reset");
                    count.set(0);
                }
            }
        });

        System.out.println("done");
    }
}
