package jdk8;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Lamda {
    public static void main(String[] args) {
        List<String> nameList=new ArrayList<>();
        Collections.sort(nameList,(s1,s2)->(Integer.compare(s1.length(),s2.length())));
        Collections.sort(nameList, comparingInt(String::length));
        nameList.sort(comparingInt(String::length));

    }
}
