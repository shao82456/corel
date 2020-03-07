package jvm;

public class Test {
    public static void main(String[] ars) throws InterruptedException {
//        System.out.println(Thread.activeCount());
        waitnote();
    }


    public static void factors(int n){
        int m=n;
        StringBuffer out=new StringBuffer("");
        for(int k=2;m>1&&k*k<=n;){
            if(m%k!=0){
                k++;
                continue;
            }
            m/=k;
            out.append((k*m==n?"":"* ")+k+" ");
        }
        if(m>1)
            out.append("* "+m);
        if(m!=n)
            System.out.println(out);
        else
            System.out.println(n+" is Prime");
    }

    static void waitnote() throws InterruptedException {
        Object c=new Object();
        c.wait();
    }
}
