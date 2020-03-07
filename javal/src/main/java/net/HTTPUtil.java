package net;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class HTTPUtil {
    HttpURLConnection con;
    String rootURL;
    public HTTPUtil(String  url) {
        this.rootURL=url;
        try {
            this.con =(HttpURLConnection) new URL(url).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get() throws IOException {
        con.setRequestMethod("GET");
        con.connect();
        Scanner res=new Scanner(con.getInputStream());
        StringBuilder sb=new StringBuilder();
        while(res.hasNextLine()){
            sb.append(res.nextLine()+"\n");
        }
        con.disconnect();
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
//
//        Map<String, List<String>> req=con.getHeaderFields();
//        System.out.println(req.size());
//        for(Map.Entry<String,List<String>> entry :req.entrySet()){
//            System.out.print(entry.getKey()+" ");
//            System.out.println(entry.getValue());
//        }
//        con.connect();
//        System.out.print(con.getResponseMessage());
//
        long start=System.currentTimeMillis();
        ExecutorService es= Executors.newCachedThreadPool();
        for(int i=0;i<3;i++){
            es.execute(new TestTomcat());
        }

//        es.shutdown();
//        testHttpSocket();
//        testHttpURLConn();
    }

    static class TestTomcat implements Runnable{
        @Override
        public void run() {
            Socket socket=null;
            try {
                socket=new Socket("bw",8080);
                StringBuilder sb=new StringBuilder();
                sb.append("GET / HTTP/1.1\r\n");
                sb.append("Host: bw:8080\r\n");
                sb.append("\r\n");

                socket.getOutputStream().write(sb.toString().getBytes());
                socket.getOutputStream().flush();
                System.out.println("send request");
                InputStream res=socket.getInputStream();
                FileOutputStream fs=new FileOutputStream("testlog/"+Thread.currentThread().getName()+".log");
                byte[] bytes = new byte[1024];
                int len = -1;
                while ((len = res.read(bytes)) != -1) {
                    fs.write(bytes, 0, len);
                }
                fs.close();
                socket.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void testHttpSocket(){
        Socket socket=null;
        try {
            socket=new Socket("bw",8080);
            //InetAddress.getLocalHost(),port
            StringBuilder sb=new StringBuilder();
            sb.append("GET / HTTP/1.1\r\n");
            sb.append("Host: bw:8080\r\n");
//            sb.append("Connection: keep-alive\r\n");
//            sb.append("Cache-Control: max-age=0\r\n");
//            sb.append("Upgrade-Insecure-Requests: 1\r\n");
//            sb.append("User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36\r\n");
//            sb.append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\r\n");
//            sb.append("Accept-Encoding: gzip, deflate\r\n");
//            sb.append("Accept-Language: zh-CN,zh;q=0.9\r\n");
            sb.append("\r\n");
            socket.getOutputStream().write(sb.toString().getBytes());
            socket.getOutputStream().flush();
            System.out.println("send request");
            InputStream res=socket.getInputStream();
            FileOutputStream fs=new FileOutputStream(Thread.currentThread().getName()+".log");
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = res.read(bytes)) != -1) {
                fs.write(bytes, 0, len);
            }
            fs.close();
            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testHttpURLConn() throws IOException {
        HTTPUtil h=new HTTPUtil("http://bw:8080");
        System.out.println(h.get());
    }

    static class TestTomcat2 implements Runnable{

        @Override
        public void run() {
            HTTPUtil h=new HTTPUtil("http://bw:8080");
            try {
                System.setOut(new PrintStream("testlog1/"+Thread.currentThread().getName()+".log"));
                System.out.println(h.get());
                System.setOut(System.out);
                System.out.println("after out");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
