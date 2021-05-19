package com.youzm.stack;

import java.util.Stack;

public class Solution32 {
    public boolean isValid(String S) {
        Stack<Character> stack=new Stack<>();
        char[] chars=S.toCharArray();
        for(char c:chars){
            if(c=='a'||c=='b'){
                stack.push(c);
            }else {
                if(stack.empty())return false;
                if(stack.peek()!='b'){
                    return false;
                }else {
                    stack.pop();
                    if(stack.empty()) return false;
                    if(stack.peek()!='a'){
                        return false;
                    }else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.empty();
    }
}
