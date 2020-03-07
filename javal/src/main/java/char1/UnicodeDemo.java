package char1;

public class UnicodeDemo {
    static void implementChars(){
    /*眼睛字符 1F440，java中无法用char表示*/
//        char c='\u1f440';
        String s2="\u1f440";
        System.out.println(s2);
        System.out.println(Character.isSupplementaryCodePoint(0x1f440));
    }
    static void normalChars(){
        char c='\u0041';
        String s1="\u0041";
        System.out.println(s1);
        System.out.println(Character.isSupplementaryCodePoint(0x0041));
    }

    public static void main(String[] args) {
//         implementChars();
         normalChars();
    }
}
