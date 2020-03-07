package proxy.handlers;


import log1.Logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerHandler implements InvocationHandler, Logging {

    private Object real;

    public TimerHandler(Object real) {
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        Object res = method.invoke(real, args);
        long elapsed = System.nanoTime() - start;
        log.info(method.getName()+" elapsed :"+elapsed);
        return res;
    }
}
