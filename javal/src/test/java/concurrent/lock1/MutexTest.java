package concurrent.lock1;

import junit.framework.TestCase;

import java.util.concurrent.*;

/**
 * Author: shaoff
 * Date: 2020/5/28 22:23
 * Package: concurrent.lock1
 * Description:
 */
public class MutexTest extends TestCase {
    Mutex mutex=new Mutex();
    ThreadPoolExecutor es= new ThreadPoolExecutor(3, 3,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    @Override
    public void setUp() throws Exception {
        es.prestartAllCoreThreads();
    }

    public void testLock() {
        Runnable t1=()->{
            sleep(1);
            System.out.println(Thread.currentThread().getName()+"doing something");
            mutex.lock();
            System.out.println("in critical section");
            System.out.println(Thread.currentThread().getName()+"doing critical");
            sleep(1);
            System.out.println("finish critical section");
            mutex.unlock();
            sleep(1);
            System.out.println(Thread.currentThread().getName()+"doing something");
        };
        es.execute(t1);
        es.execute(t1);
        es.execute(t1);

        System.out.println(es.getActiveCount());
    }

    public void testTryLock() {

    }

    public void testLockInterruptibly() {
    }

    static void sleep(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}