package time;

import java.util.Random;

/**
 * Author: shaoff
 * Date: 2020/5/30 13:22
 * Package: time
 * Description:
 * <p>
 * 测试算法时间复杂度与耗时
 */
public class TimeTest {
    static Random random = new Random();

    static byte[] prepareData(int level) {
        byte[] data = new byte[(int) Math.pow(10, level)];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) random.nextInt();
        }
        return data;
    }


    static void test(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        long end = System.currentTimeMillis();
        long duration=end - start;
        System.out.println("time overhead:" + duration);
    }

    static void testN() {
        long start=System.currentTimeMillis();
        for (int i = 1; i < 10; i++) {
            byte[] data = prepareData(i);
            Runnable t=new Runnable() {
                @Override
                public void run() {
                    int total=0;
                    for(int num:data){
                        total+=num;
                    }
//                    System.out.println(total);
                }
            };
            test(t);
        }
        long end=System.currentTimeMillis();
        System.out.println("finished test,"+(end-start));
    }

    static void testN2(){
        for (int i = 1; i < 10; i++) {
            byte[] data = prepareData(i);
            Runnable t=new Runnable() {
                @Override
                public void run() {
                    int total=0;
                    for(int num:data){
                        int total2=0;
                        for(int num2:data) {
                            total2 += num;
                        }
                        total+=total2;
                    }
                    System.out.println(total);
                }
            };
            test(t);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testN2();
//        byte[] data=prepareData(9);
        Thread.sleep(1000*10);
    }
}
