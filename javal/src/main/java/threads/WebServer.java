package threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {
    private final ExecutorService es= Executors.newCachedThreadPool();

    public void start() throws IOException {
        ServerSocket socket=new ServerSocket(8800);
        while (!es.isShutdown()){
            Socket conn=socket.accept();
            System.out.println("conn to:"+conn.getRemoteSocketAddress());
            es.execute(new Runnable() {
                @Override
                public void run() {
                    handleRequest(conn);
                }
            });
        }
    }

    private void handleRequest(Socket conn)  {
        PrintWriter pw= null;
        try {
            pw = new PrintWriter(conn.getOutputStream());
            pw.println("welcom");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pw!=null) {
                pw.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new WebServer().start();
    }
}
