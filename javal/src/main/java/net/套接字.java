package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class 套接字 {

    int port=9999;
    public  void start() throws Exception {
        ServerSocket serverSocket=new ServerSocket(9999);
        while (true){
            Socket socket=serverSocket.accept();
            Thread.sleep(1000);
            new Thread(()->{
                handle(socket);
            }).start();
        }

    }

    private void handle(Socket socket) {
        try {
            InputStream in=socket.getInputStream();
            OutputStream out=socket.getOutputStream();
            Scanner scanner=new Scanner(in);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            String res="HTTP/1.1 204 No Content\r\n";
            String res2="Connection: close\r\n";
            out.write(res.getBytes());
            out.write(res2.getBytes());
            out.flush();

        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }

    public static void main(String[] args) throws Exception {
        new 套接字().start();
    }
}
