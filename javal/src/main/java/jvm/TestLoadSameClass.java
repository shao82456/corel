package jvm;

public class TestLoadSameClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c=Class.forName("TestInfo");
    }
}
