package jvm.clazz;

/**
 * Author: shaoff
 * Date: 2020/4/23 11:18
 * Package: jvm.clazz
 * Description:
 */
class Bean {
    static final String WRITER="shaofengfeng";
    static final boolean READY=false;
    int c=2;
    String f1;
    public String f2;
    void m1(){
        int a=1;
        System.out.println("...");
    }
    public void m2(){
        c+=10;
    }
    <T> void m3(T input){
        System.out.println(input.getClass());
    }
}