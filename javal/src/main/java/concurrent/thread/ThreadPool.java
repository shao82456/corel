package concurrent.thread;

import java.util.concurrent.*;

/**
 * Author: shaoff
 * Date: 2020/7/8 13:31
 * Package: concurrent.thread
 * Description:
 */
public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        int a=tryTest2();
        System.out.println(a);
    }

    static void exceptionTest() throws Exception{
        ThreadPoolExecutor executor= new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        executor.execute(()->{
            try {
                Thread.sleep(3);
                throw new NullPointerException();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(10);
        int c=executor.getActiveCount();
        System.out.println(c);
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(Thread.activeCount());
    }

    static int[] tryTest(){
        int[] num=new int[]{10};
        int a=10;
        a+=1;
        try{
            num[0]/=1;
            return num ;
        }catch (Exception e){
            num[0]-=1;
            return num;
        }finally {
            num[0]=0;
        }
    }

    static int tryTest2(){
        int a=3;
        try{
            a+=1;
            return a;
        }catch (Exception e) {
            a+=2;
            return 10;
        }finally {
            a=5;
            return 4;
        }
    }
}
