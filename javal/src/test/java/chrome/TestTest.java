package chrome;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestTest {

    @Test
    public void read() throws IOException {
        Scanner scanner=new Scanner(new File("/home/sakura/Downloads/alltable.csv"));
        int filtered=0;
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            String[] filed=line.split(",");

            if(filed.length!=5){
                System.err.println(line);
                filtered++;
            }

            String id=filed[0];
            String name=filed[1];
            String path=filed[2];
            String email=filed[3];
            String cluster=filed[4];
            String url="http://dp.pt.xiaomi.com/view?id="+id;
            System.out.println(url);
        }

        System.out.println("filterd record count:"+filtered);
        scanner.close();
    }
}