package com.youzm.stack;

import java.util.Stack;

/**
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * 请返回任意一个合法字符串。
 */
public class Solution34 {
    public String minRemoveToMakeValid(String s) {
        char[] chars=s.toCharArray();
        int length=s.length();
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<length;i++){
          if(chars[i]==')'){
              if(!stack.empty()&&chars[stack.peek()]=='('){
                  stack.pop();
              }else {
                  stack.push(i);
              }
          }else if(chars[i]=='('){
             stack.push(i);
          }
        }

        while (!stack.empty()){
           sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution34 solution34=new Solution34();
        String str="lee(t(c)o)de)";
        System.out.println(solution34.minRemoveToMakeValid(str));
    }
}
