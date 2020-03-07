package chrome;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;


public class Execute {

    @Test
    public void executor() throws IOException {
        FileOutputStream out=new FileOutputStream("test1.txt");
        FileOutputStream err=new FileOutputStream("test2.txt");

        PumpStreamHandler pumpStreamHandler=new PumpStreamHandler(out,err);

        DefaultExecutor executor=new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);

        executor.execute(CommandLine.parse("ls /"));

        out.close();
        out.write("hello".getBytes());



    }
}
