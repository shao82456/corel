package proxy.handler.demo;

import proxy.handler.functions.Function1;
import proxy.handler.functions.Say;
import proxy.handler.handlers.TimerHandler;
import proxy.handler.handlers.WrapperUtil;

import java.io.*;
import java.lang.reflect.Method;

/**
 * Author: shaoff
 * Date: 2020/6/23 15:11
 * Package: proxy.handlers.Demo
 * Description:
 */

public class Demo {

    static void testFunction(){
        Function1<String,Void> sayHi=new Say<>();
        sayHi.f("hi");
    }

    static void testProxy(){
        Say<String> sayHello= new Say<>();
        TimerHandler t=new TimerHandler(sayHello);
        Function1<String,Void> proxy= WrapperUtil.wrap(t,Function1.class);
        long start= System.currentTimeMillis();
        proxy.f("hello");
        System.out.println("duration: "+(System.currentTimeMillis()-start));


        System.out.println(proxy.getClass().getSimpleName());
        for(Method m:proxy.getClass().getMethods()){
            System.out.println(m.getName());
        }
    }

    public static void main(String[] args) throws Exception {
        testProxy();
    }

    static void testSerialization() throws Exception {
        Say<String> sayHello= new Say<>();
        TimerHandler t=new TimerHandler(sayHello);
        Function1<String,Void> proxy= WrapperUtil.wrap(t,Function1.class);

        ObjectOutputStream outputStream=new ObjectOutputStream(System.out);
        File dat=new File("proxy/handler/demo/Demo/dat1");
        dat.getParentFile().mkdirs();

//        dat.createNewFile();
        ObjectOutputStream outputStream2=new ObjectOutputStream(new FileOutputStream(dat));

        outputStream.writeObject(proxy);
        outputStream2.writeObject(proxy);
    }

    static void testDeserialization() throws Exception {
        File dat=new File("proxy/handler/demo/Demo/dat1");
        assert dat.exists();
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(dat));
        Object o= inputStream.readObject();
        Function1<String,Void> proxy= (Function1<String, Void>) o;
        proxy.f("hello");
    }
}
