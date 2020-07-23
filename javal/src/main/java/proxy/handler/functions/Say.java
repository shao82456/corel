package proxy.handler.functions;

public class Say<T> implements Function1<T, Void> {
    @Override
    public Void f(T content) {
        System.out.println(content);
        return null;
    }

}