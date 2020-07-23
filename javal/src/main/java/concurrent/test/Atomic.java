package concurrent.test;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Author: shaoff
 * Date: 2020/5/6 13:23
 * Package: concurrent.test
 * Description:
 */
class Variable{
    static AtomicBoolean b=new AtomicBoolean(false);

}
public class Atomic {
    static Runnable t1= () -> {
        Random random=new Random();
      while (true){
          try {
              Thread.sleep(random.nextInt(500)+500);
              if(!Variable.b.getAndSet(true)){
                  System.out.println("first set");
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    };

    static void testCommunication(){

    }
    public static void main(String[] args) {
        ExecutorService es= Executors.newFixedThreadPool(5);
        es.execute(t1);
    }
}
