package com.youzm.stack;

import java.util.Stack;

public class Solution14 {
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        char[] chars=S.toCharArray();
        for(char c:chars){
            if(!stack.empty()&&c==stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.empty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
    public String removeDuplicates1(String S) {
        char[] s = S.toCharArray();
        int len = s.length;
        int cnt = 1;
        char pre = s[0];
        char[] oup = new char[len];
        oup[0] = pre;
        int i = 1;
        char cur = ' ';
        while (i < len) {
            cur = s[i];
            if (cur == pre) {
                cnt--;
                if (cnt == 0) {
                    pre = ' ';
                } else {
                    pre = oup[cnt - 1];
                }
            } else {
                oup[cnt] = cur;
                cnt++;
                pre = cur;
            }
            i++;
        }
        if (cnt == 0) return "";
        return String.valueOf(oup, 0, cnt);

    }

    public static void main(String[] args) {
        Solution14 solution14=new Solution14();
        String str="abbaca";
        System.out.println(solution14.removeDuplicates(str));
    }
}
