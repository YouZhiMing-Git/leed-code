package com.youzm.stack;

import java.util.Stack;

public class Solution22 {

    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        char[] chars=s.toCharArray();
        for(char c:chars){
            if(stack.empty()){
                stack.push(c);
            }
            else {
                if(Math.abs(c-stack.peek())==32){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.insert(0,"");
        while (!stack.empty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution22 solution22=new Solution22();
        System.out.println('a'-'A');
        String str="leEeetcode";
        System.out.println(solution22.makeGood(str));
    }
}
