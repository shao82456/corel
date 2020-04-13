package classloading1.test;

/**
 * Author: shaoff
 * Date: 2020/3/22 03:33
 * Package: classloading1.test
 * Description:
 */
public class MyObject {
    static String name="cool";
    static{
        System.out.println(MyObject.class.getName()+" loaded");
    }
}
