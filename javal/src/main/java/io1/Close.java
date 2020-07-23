package io1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Close {

    static private void testWrite() throws IOException, InterruptedException {
        String path="/Users/sakura/close.txt";
        File f=new File(path);
        FileOutputStream fo = new FileOutputStream(f);
            for (int i = 0; i < 30; i++) {
                fo.write((i + "abc\n").getBytes());
                Thread.sleep(500);
            }
            fo.close();
    }

    public static void main(String[] args) throws Exception {
        testWrite();
    }
}
