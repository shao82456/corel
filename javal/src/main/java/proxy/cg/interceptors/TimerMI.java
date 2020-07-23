package proxy.cg.interceptors;


import log1.Logging;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerMI implements MethodInterceptor,Logging, Serializable {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = proxy.invokeSuper(obj, args);
        long elapsed = System.currentTimeMillis() - start;
        log.info(method.getName()+" elapsed: "+elapsed);
        return res;
    }
}
