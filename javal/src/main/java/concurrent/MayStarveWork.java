package concurrent;

public class MayStarveWork {
    static volatile boolean[] flag=new boolean[2];
    public static void main(String[] args) throws InterruptedException {
        Thread th0=new Thread(()->{
            while (true) {
                while (flag[1]);
                flag[0]=true;
                System.out.println("hello");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag[0]=false;
            }
        });

        Thread th1=new Thread(()->{
            while (true) {
                while (flag[0]) ;
                flag[1]=true;
                System.out.println("world");
                flag[1]=false;
            }
        });

        th0.start();th1.start();
        th0.join();th1.join();
    }
}
