package stack1;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*20. Valid Parentheses*/
    public boolean isValid(String s) {
        List<Character> stk = new ArrayList<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                stk.add(c);
            }else if(c==')'){
                if(stk.size()==0||stk.remove(stk.size()-1)!='('){
                    return false;
                }
            }else if(c==']'){
                if(stk.size()==0||stk.remove(stk.size()-1)!='['){
                    return false;
                }
            }else if(c=='}'){
                if(stk.size()==0||stk.remove(stk.size()-1)!='{'){
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
