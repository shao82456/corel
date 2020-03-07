package other;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    static String mdtStr(String str) throws UnsupportedEncodingException {
        return new String(messageDigest.digest(str.getBytes()),"utf-8");
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(mdtStr("862844039700347"));
    }
}
