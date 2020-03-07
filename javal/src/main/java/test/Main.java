package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("abc");
        s.add("def");
        System.out.println(s.size());
        s.removeIf(str -> str.equals("abc"));
        System.out.println(s.size());
    }
}
