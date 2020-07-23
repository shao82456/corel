package serialization;

import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID=1L;
    String name;
    int age;
    double score;

    private Student() {
        System.out.println("default constructor invoked");
    }

    private Student(String name) {
        this.name = name;
    }

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    /*private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
        System.out.println("ll");
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    static {
        System.out.println("static block once");
    }
    {
        System.out.println("dynamic block once");
    }

    /*private Object readResolve() {
        return new Student("wang");
    }*/
}

public class Test{
    public static void main(String[] args) throws Exception {

//        Student[] students=new Student[1];
//        students[0]=new Student("shao",20,90);
        /*ObjectOutputStream out = new ObjectOutputStream(
                (new FileOutputStream("/Users/sakura/stuff/stuff-projects/corel/javal/students.dat")));
        Student st=new Student("shao",20,90);
        out.writeObject(st);*/
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/sakura/stuff/stuff-projects/corel/javal/students.dat"));
        Student newInstance = (Student) ois.readObject();
        System.out.println(newInstance);
//        Student st=new Student("shao",20,90);
//        Class studentClass=Class.forName("serialization.Student");
//        Student st= (Student) studentClass.getConstructor().newInstance();
    }
}