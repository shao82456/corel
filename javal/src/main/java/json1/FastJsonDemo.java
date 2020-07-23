package json1;

import com.alibaba.fastjson.JSON;

/**
 * Author: shaoff
 * Date: 2020/5/2 19:21
 * Package: json1
 * Description:
 */
public class FastJsonDemo {
    static void test1(){
        User user = new User("12", "wang", "wang123");
        String js=JSON.toJSONString(user);
        System.out.println(js);
        User user1=JSON.parseObject(js,User.class);
        System.out.println(user==user1);
    }

    public static void main(String[] args) {
        test1();
    }
}
