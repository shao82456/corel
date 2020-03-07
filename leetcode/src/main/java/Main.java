import javax.accessibility.*;
import java.sql.Date;
import java.util.*;

public class Main {
    Date d=new Date(0);
    public static void main(String[] args) {
        System.out.println("gg");
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();
        h1.put('a',1);h1.put('b',2);
        h2.put('b',2);h2.put('a',1);
        System.out.println(h1.equals(h2));
        HashSet<Map<Character, Integer>> h3=new HashSet<>();
        h3.add(h1);
        h3.add(h2);
        System.out.println(h3.size());
    }
}

