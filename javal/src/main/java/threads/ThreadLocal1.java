package threads;

public class ThreadLocal1 {
    private static final  ThreadLocal<Long> TIME_THREADLOCAL=new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static void main(String[] args) {
        long duration=System.currentTimeMillis()-TIME_THREADLOCAL.get();
        System.out.println(duration);
    }
}
