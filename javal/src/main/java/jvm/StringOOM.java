package jvm;

import sun.java2d.opengl.OGLContext;

import java.util.ArrayList;
import java.util.List;

public class StringOOM {
    static String base = "string";

    public static void main(String[] args) throws InterruptedException {
        byte[] bs=new byte[1024*1000*6];
        byte[] bs1=new byte[1024*1000];
        byte[] bs2=new byte[1024*1000];
        byte[] bs3=new byte[1024*1000];
        byte[] bs4=new byte[1024*1000];

//        while (true){
//            byte[] bs1=new byte[1024*1000];
//            byte[] bs2=new byte[1024*1000];
//            byte[] bs3=new byte[1024*1000];
//
//            Thread.sleep(1000*30);
//        }
    }

    void test(){
        byte[] bs1=new byte[1024*1000];
        byte[] bs2=new byte[1024*1000];
        byte[] bs3=new byte[1024*1000];
        byte[] bs4=new byte[1024*1000];
    }
}
