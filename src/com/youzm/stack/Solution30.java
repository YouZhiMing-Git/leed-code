package com.youzm.stack;

import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 */
public class Solution30 {
    /*转换为数学问题
    * 核心都是对  （）  的累乘
    *
    * */
    public int scoreOfParentheses(String S) {

        char[] chars=S.toCharArray();
        int ans=0;
        int bal=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                bal++;
            }else {
                bal--;
                if(chars[i-1]=='('){
                    ans+=1<<bal;
                }
            }
        }
        return ans;
    }
    public int scoreOfParentheses1(String S){
        Stack<Integer> stack=new Stack<>();
        char[] chars=S.toCharArray();
        for(char c:chars){
            if(c=='('){
                stack.push(0);
            }
            else {
                if(stack.peek()==0){
                    stack.pop();
                    stack.push(1);
                }else {
                    int value=0;
                    while (stack.peek()!=0){
                        value+=stack.pop();
                    }
                    stack.pop();
                    value*=2;
                    stack.push(value);
                }
            }
        }
        int ans=0;
        while (!stack.empty()){
            ans+=stack.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution30 solution30=new Solution30();
        String str="(()(()))";
        System.out.println(solution30.scoreOfParentheses(str));
    }
}
