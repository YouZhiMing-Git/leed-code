package com.youzm.stack;

import java.util.Stack;

public class Solution13 {
    public String removeOuterParentheses(String S) {
        StringBuilder sb=new StringBuilder();
        int level=0;
        for(char c:S.toCharArray()){

            if(c==')') level--;
            if(level>0) sb.append(c);
            if(c=='(') level++;
        }
        return sb.toString();
    }
    public String removeOuterParentheses1(String S) {
       Stack<Character> stack =new Stack();
       StringBuilder sb=new StringBuilder();
       char[] chars=S.toCharArray();
       for(char c:chars){
           if(c==')')stack.pop();
           if(!stack.empty())sb.append(c);
           if(c=='(')stack.push(c);
       }
       return sb.toString();
    }
    public static void main(String[] args) {
        Solution13 solution13=new Solution13();
        String str="(()())(())";
        System.out.println(solution13.removeOuterParentheses1(str));

    }
}
