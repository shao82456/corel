package exp;

/**
 * Author: shaoff
 * Date: 2020/7/22 20:55
 * Package: exp
 * Description:
 */
public class Try {
    static int f(){
        int a;
        try{
            int b=1;
            a=b-1;
            return a;
        }catch (Exception e){
            int c=2;
            return c;
        }finally {
            a=10;
            return 10;
        }
    }


    public static void main(String[] args) {
        int res=f();
        System.out.println(res);
    }
}
