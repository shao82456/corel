package concurrent;

public class SequencellyWork {
    static volatile int turn=0;

    public static void main(String[] args) throws InterruptedException {
        Thread th0=new Thread(()->{
            while (true) {
                while (turn == 1) ;
                System.out.println("hello");
                turn = 1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread th1=new Thread(()->{
            while (true) {
                while (turn == 0) ;
                System.out.println("world");
                turn = 0;
            }
        });

        th0.start();th1.start();
        th0.join();th1.join();
    }
}
