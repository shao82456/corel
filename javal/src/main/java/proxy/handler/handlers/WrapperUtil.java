package proxy.handler.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Author: shaoff
 * Date: 2020/6/23 15:27
 * Package: proxy.handler.handlers
 * Description:
 */
public class WrapperUtil {
    public static <T> T wrap(InvocationHandler h,Class<T> interface0){
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{interface0} , h);
    }

    public static Object wrap(InvocationHandler h,Class<?>[] interfaces){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),interfaces, h);
    }
}
