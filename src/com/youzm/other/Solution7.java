package com.youzm.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution7 {

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>(3);
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        char[] chars=s.toCharArray();
        for(char c:chars){
            if(stack.size()==0){
                stack.push(c);
            }
            else if(stack.peek().equals(map.get(c))){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
