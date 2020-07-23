package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class SomeThing{
    int a=10;
}

public class Array {

    public static void testArayCopy(){
        SomeThing[] someThings=new SomeThing[5];
        for(int i:Arrays.asList(1,2,3,4,5) ){
            someThings[i-1]=new SomeThing();
        }
        SomeThing[] someThings1=Arrays.copyOf(someThings,someThings.length+1);
        for(int i:Arrays.asList(0,1,2,3,4))
            System.out.println(someThings[i]==someThings1[i]);
    }
    public static void main(String[] args) {
//        testArayCopy();
        int a=1<<30;
        System.out.println(a);
    }
}
