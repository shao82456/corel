package proxy;

import proxy.function.HelloService;

public class OneService implements HelloService {
    @Override
    public void sayHello(){
        System.out.println("hello");
    }

    public void sleepLittle() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("awaking");
    }
}
