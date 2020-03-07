package concurrent;


import java.util.Scanner;

class Job1 implements Runnable{
    @Override
    public void run() {

        synchronized (State.class) {
            try {
                State.class.wait(1000 * 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Job2 implements Runnable{
    @Override
    public void run(){
        synchronized (State.class){
            System.out.println(Thread.currentThread().getName()+" "+"get monitor");
            Scanner scanner=new Scanner(System.in);
            System.out.println(scanner.nextInt());
        }
    }
}

/**
 * Java线程的状态: NEW RUNNABLE BLOCKED WAITING TIMED_WAITING TERMINATED
 * 线程进入synchronized块时等待对象，进入BLOCKED
 * 执行wait,join,park进入WAITING状态
 * 执行sleep,wait with timeout,join with timeout,parkNanos，parkUntil等操作会进入，sleep不会释放监视器
 * 进入TERMINATED，由于正常完成或发生致命错误，unhandled exception
 */


public class State {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Job1());

        System.out.println(t1.getName()+" "+t1.getState());
        t1.start();
        System.out.println(t1.getName()+" "+t1.getState());
        Thread.sleep(1000);
        System.out.println(t1.getName()+" "+t1.getState());
        Thread t2=new Thread(new Job2());
        t2.start();
        System.out.println(t2.getName()+" "+t2.getState());
        Thread.sleep(1000);
        System.out.println(t2.getName()+" "+t2.getState());

    }

}
