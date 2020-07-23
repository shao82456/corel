//package proxy.handlers;
//
//import org.apache.log4j.Logger;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//
//public class LogHandler implements InvocationHandler,Log {
//    private  static Logger logger= Logger.getLogger(Logger.class);
//    private Object real;
//
//    public LogHandler(Object real) {
//        this.real = real;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        logger.info("invoke:"+method.getName());
//        Object res=method.invoke(real,args);
//        return res;
//    }
//}
