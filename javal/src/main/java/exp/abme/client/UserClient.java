package exp.abme.client;

import exp.abme.lib.Function;

/**
 * Author: shaoff
 * Date: 2020/4/16 14:44
 * Package: exp.abme.client
 * Description:
 */
public class UserClient{
    Function function;

    {
        try {
            function = (Function) Class.forName("exp.abme.lib.FunctionImpl").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exec(){
        function.f2();
    }
}