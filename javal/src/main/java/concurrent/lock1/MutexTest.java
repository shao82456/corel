package concurrent.lock1;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Author: shaoff
 * Date: 2020/5/28 22:23
 * Package: concurrent.lock1
 * Description:
 */
public class MutexTest  {
    static Mutex mutex=new Mutex();
    static ThreadPoolExecutor es= new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    static void setUp() {
        es.prestartAllCoreThreads();
    }

    public static void main(String[] args) {
        setUp();
        testLock();
    }

    public static void testLock() {
        Runnable t1=()->{
            Random random=new Random();
            sleep(random.nextInt(3));
            System.out.println(Thread.currentThread().getName()+" doing something");
            mutex.lock();
            System.err.println("in critical section");
            System.err.println(Thread.currentThread().getName()+" doing critical");
            sleep(random.nextInt(3));
            System.err.println("finish critical section");
            mutex.unlock();
            sleep(random.nextInt(3));
            System.out.println(Thread.currentThread().getName()+" doing something");
        };
        es.execute(t1);
        es.execute(t1);
    }

    public static void testUnfair(){
        Runnable t1=()->{
            sleep(1);
            System.out.println(Thread.currentThread().getName()+" doing something begin");
            mutex.lock();
            System.err.println("in critical section");
            System.err.println(Thread.currentThread().getName()+" doing critical");
            sleep(5);
            System.err.println("finish critical section");
            mutex.unlock();
            System.out.println(Thread.currentThread().getName()+" doing something end");
        };
        Runnable t2=()->{
            sleep(2);
            System.out.println(Thread.currentThread().getName()+" doing something begin");
            mutex.lock();
            System.err.println("in critical section");
            System.err.println(Thread.currentThread().getName()+" doing critical");
            System.err.println("finish critical section");
            mutex.unlock();
            System.out.println(Thread.currentThread().getName()+" doing something end");
        };
        Runnable t3=()->{
            sleep(6);
            System.out.println(Thread.currentThread().getName()+" doing something begin");
            mutex.lock();
            System.err.println("in critical section");
            System.err.println(Thread.currentThread().getName()+" doing critical");
            System.err.println("finish critical section");
            mutex.unlock();
            System.out.println(Thread.currentThread().getName()+" doing something end");
        };

        Runnable t4=()->{
            sleep(6);
            System.out.println(Thread.currentThread().getName()+" doing something begin");
            mutex.lock();
            System.err.println("in critical section");
            System.err.println(Thread.currentThread().getName()+" doing critical");
            System.err.println("finish critical section");
            mutex.unlock();
            System.out.println(Thread.currentThread().getName()+" doing something end");
        };

        Runnable t5=()->{
            sleep(6);
            System.out.println(Thread.currentThread().getName()+" doing something begin");
            mutex.lock();
            System.err.println("in critical section");
            System.err.println(Thread.currentThread().getName()+" doing critical");
            System.err.println("finish critical section");
            mutex.unlock();
            System.out.println(Thread.currentThread().getName()+" doing something end");
        };

        es.execute(t1);
        es.execute(t2);
        es.execute(t3);
        es.execute(t4);
        es.execute(t5);
    }

    static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}