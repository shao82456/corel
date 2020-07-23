package concurrent.deadlock;

import java.util.concurrent.*;

/**
 * Author: shaoff
 * Date: 2020/4/23 00:33
 * Package: concurrent.deadlock
 * Description:
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        checkDeadLock();
    }

    /*制造死锁，测试jdk工具能否检测出来*/
    static void checkDeadLock() throws Exception {
        ExecutorService ex= Executors.newCachedThreadPool();
        BlockingQueue<String> msgs=new LinkedBlockingQueue<>();
        ex.execute(()->{
            synchronized (Demo.class){
                try {
                    System.out.println(msgs.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.currentThread().join();
        Thread.sleep(10);
        synchronized (Demo.class){
            msgs.offer("never arrived msg");
        }
    }





}
