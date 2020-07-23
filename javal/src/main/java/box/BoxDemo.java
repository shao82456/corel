package box;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: shaoff
 * Date: 2020/6/1 11:07
 * Package: box
 * Description:
 */
public class BoxDemo {
    static int a=1;
    static Integer b=2;
    static List<Integer> arr=new ArrayList<>();
    public static void main(String[] args) {
        arr.add(a); //编译器自动增加了Integer.valueOf(a)的调用
        arr.add(b);
        int c=b+1; //编译器自动增加哀乐b.intValue()的调用

        boolean refEq=a==b; //这里自动拆箱
        Integer d=2;
        boolean refEq2=b==d; //直接比较的引用，由于cache,两者一致
        System.out.println(refEq2);
        Integer e=new Integer(2);
        System.out.println(b==e); //直接比较引用，两个对象
        System.out.println(b.equals(e)); //true
    }
}
