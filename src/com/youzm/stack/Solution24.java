package com.youzm.stack;

import java.util.Stack;

public class Solution24 {
    public int minAddToMakeValid(String S) {

        int result = 0;
        if (S.length() == 0) return result;
        Stack<Character> stack = new Stack<>();
        char[] chars=S.toCharArray();
        for(char c:chars){
            if(!stack.empty()&&stack.peek()=='('&&c==')'){
                stack.pop();
            }else stack.push(c);
        }

        return stack.size();
    }
}
