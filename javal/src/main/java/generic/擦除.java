package generic;

import java.util.ArrayList;
import java.util.List;

class Pair<U, V> {

    U first;
    V second;

    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }

    public Pair() {
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        List<U> ls=new ArrayList();
        if(first instanceof String){
            return first.toString();
        }else if(first instanceof Integer){
            return Integer.parseInt(first.toString())+":";
        }else{
            return first.getClass().getSimpleName();
        }
    }
}

public class 擦除 {

    public static void main(String[] args) {
        Pair<Integer,String> pair=new Pair<>(1,"abc");
        Pair<String,String> pair2=new Pair<>("def","abc");
        System.out.println(pair2.getClass().getSimpleName());
    }
}
