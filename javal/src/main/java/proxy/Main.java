//package proxy;
//
//import proxy.function.HelloService;
//import proxy.handlers.LogHandler;
//import proxy.handlers.TimerHandler;
//
//import java.lang.reflect.Proxy;
//
//public class Main {
//    public static void main(String[] args) {
//        OneService service=new OneService();
//        HelloService logProxy=(HelloService) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{HelloService.class},
//            new LogHandler(service));
//
//        HelloService timerProxy=(HelloService) Proxy.newProxyInstance(Main.class.getClassLoader(),new Class[]{HelloService.class},
//            new TimerHandler(service));
//        logProxy.sayHello();
//        timerProxy.sayHello();
//    }
//}
