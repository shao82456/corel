//package 继承;
//
///**
// * Author: shaoff
// * Date: 2020/3/21 23:46
// * Package: 继承
// * Description:
// */
//
//import java.net.URL;
//
///**
// * 静态字段，静态方法是可以继承的，也可以在子类中通过定义隐藏父类的静态字段或方法
// * 之所以可以继承，是因为对静态字段或方法的引用会类在解析时，会进行静态引用
// */
//public class 静态 {
//    private static class Base{
//        /*静态属性可以被继承*/
//        static String a="a";
//        /*静态方法可以被继承*/
//        static void f(){
//            System.out.println("function f");
//        }
//        static String b="b";
//    }
//
//    private static class Child extends Base{
//        static String b="b1";
//    }
//    public static void main(String[] args) throws ClassNotFoundException {
//        Thread.currentThread().setContextClassLoader(new ClassLoader(null) {
//            @Override
//            protected Class<?> findClass(String name) throws ClassNotFoundException {
//                return new Class();
//                return Object.class;
//            }
//        });
//
//        Class cc=Class.forName("java.lang.Object");
//        System.out.println(cc);
//        System.out.println(cc.getClass().getClassLoader());
//        System.out.println(Thread.currentThread().getContextClassLoader());
//        System.out.println(Child.a);
//        Test.f();
//        //https://stackoverflow.com/questions/15250656/how-is-the-classloader-for-a-class-chosen
//        //jvm如何确定一个类是否已经被加载
//        System.out.println(Test.class.getClassLoader());
//        Child.f();
//        System.out.println(Child.b);
//        System.out.println(URL.class.getClassLoader());
//    }
//}
