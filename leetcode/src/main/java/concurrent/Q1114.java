package concurrent;

import java.util.concurrent.*;

class Foo {
    Object key=new Object();
    LinkedBlockingQueue<Object> q1=new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Object> q2=new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Object> q3=new LinkedBlockingQueue<>();

    public Foo() {
        try {
            q1.put(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        Object key=q1.take();
        printFirst.run();
        q2.put(key);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        Object key=q2.take();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        q3.put(key);
    }

    public void third(Runnable printThird) throws InterruptedException {
        Object key=q3.take();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

public class Q1114 {
    public static void main(String[] args) {
        Foo foo=new Foo();
        ExecutorService executor= Executors.newFixedThreadPool(3);
        executor.execute(()-> {
            try {
                foo.first(()->{
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(()-> {
            try {
                foo.second(()->{
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(()-> {
            try {
                foo.third(()->{
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }
}
