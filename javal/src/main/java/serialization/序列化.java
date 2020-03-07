package serialization;

import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID=1L;
    String name;
    int age;
    double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
        System.out.println("ll");
    }
}

public class 序列化{
    public static void main(String[] args) throws IOException {

        Student[] students=new Student[1];
        students[0]=new Student("shao",20,90);
        ObjectOutputStream out = new ObjectOutputStream(
                (new FileOutputStream("students.dat")));
        try {
            out.writeInt(students.length);
            for (Student s : students) {
                out.writeObject(s);
            }
        } finally {
            out.close();
        }
    }
}