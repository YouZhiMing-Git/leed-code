package com.youzm.stack;

import java.util.Stack;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号
 */
public class Solution38 {

    //暴力破解
    public String reverseParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        char[] chars=s.toCharArray();
        int length=s.length();
        for(int i=0;i<length;i++){
            if(chars[i]=='(')stack.push(i);
            else if(chars[i]==')'){
                reverse(chars,stack.pop()+1,i-1);
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<length;i++){
            if(chars[i]!='('&&chars[i]!=')')
                stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public  void reverse(char[] chars,int begin ,int end){
        char temp;
        while (end>begin){
            temp=chars[end];
            chars[end]=chars[begin];
            chars[begin]=temp;
            end--;
            begin++;
        }
    }
    public String reverseParentheses1(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[n];

        //先去找匹配的括号
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        // i是当前位置 | d是方向,1就是向右穿
        for (int i = 0, d = 1; i < n; i+=d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                // 如果碰到括号，那么去他对应的括号，并且将方向置反
                i = pair[i];
                d = -d;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }



    public static void main(String[] args) {
        Solution38 solution38 =new Solution38();
        String str="(ed(et(oc))el)";
        System.out.println(solution38.reverseParentheses(str));
    }
}
