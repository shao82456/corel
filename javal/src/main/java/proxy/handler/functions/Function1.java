package proxy.handler.functions;

import java.io.Serializable;

/**
 * Author: shaoff
 * Date: 2020/6/23 15:13
 * Package: proxy.handlers.Demo.functions
 * Description:
 */

public interface Function1<T,U> extends Serializable {
    U f(T arg1);
}
