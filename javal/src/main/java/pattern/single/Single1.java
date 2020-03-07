package pattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Single1 {
    String b=new String("...B");
    {
        System.out.println("init begin");
        try {
            Thread.sleep(1000*1);
            b="...B!";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    {
        System.out.println("init2 begin");
        try {
            Thread.sleep(1000*1);
            b="...B!!";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    String c=new String("...C");

    private Single1(){

    }
    static private Single1 ins;
    static public Single1 getInstance(){
        if(ins==null){
            synchronized (Single1.class){
                if(ins==null){
                    ins=new Single1();
                }
            }
        }
        ins.getClass();
        ins.getClass().getSimpleName();
        return ins;
    }

    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        for(int i=0;i<2;i++){
            es.execute(() -> {
                System.out.println(getInstance().b);
            });
        }
        System.out.println("all executing");
        es.shutdown();
    }
}
