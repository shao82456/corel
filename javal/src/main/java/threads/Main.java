package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static class DemoTask implements Runnable{
        @Override
        public void run() {
            System.out.println("running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ending");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Integer.MIN_VALUE<<1);
        if(!false&&true){
            System.out.println("tt");
        }
        ExecutorService es= Executors.newCachedThreadPool();
        es.execute(new DemoTask());
        es.execute(new DemoTask());
//        boolean terminated=es.awaitTermination(1, TimeUnit.MINUTES);
//        if(terminated){
//            System.out.println("QUIT");
//        }


//        es.shutdownNow();
    }
}
