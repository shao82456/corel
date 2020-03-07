package threads;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/*主要是判断线程在被阻塞队列阻塞时的状态
* 线程共有runnable,running,blocked,waiting,等几种状态*/
public class TestThreadState {
    private static int nth=3;
    private static LinkedBlockingDeque<String> que=new LinkedBlockingDeque<>();
    private static Executor executor= Executors.newFixedThreadPool(nth);
    public static void main(String[] args) {
        for(int i=0;i<nth;i++){
            executor.execute(() -> {
                while (true) {
                    try {
                        String data = que.take();
                        System.out.println(data);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            que.push(scanner.nextLine());
        }
    }

}
