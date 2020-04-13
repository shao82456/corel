package asyn1.futur1;

import java.util.concurrent.*;

/**
 * Author: shaoff
 * Date: 2020/3/30 00:03
 * Package: asyn1.futur1
 * Description:
 */
public class Demo {
    static ExecutorService es= Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws Exception {
        Future<String> f=es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "abc";
            }
        });
        System.out.println(f.get());
        es.shutdown();
    }
}
