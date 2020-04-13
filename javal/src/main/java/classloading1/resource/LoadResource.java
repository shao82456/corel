package classloading1.resource;

import jvm.ClassLoad;

import java.net.URL;

/**
 * Author: shaoff
 * Date: 2020/3/31 01:05
 * Package: classloading1.resource
 * Description:
 */
public class LoadResource {
    public static void main(String[] args) {
        ClassLoader cl=Thread.currentThread().getContextClassLoader();
        URL url=cl.getResource("log4j.properties");
        System.out.println(url.toString());
    }
}
