package com.youzm.stack;

import java.util.Stack;

public class Solution21 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack_s = new Stack<>();
        Stack<Character> stack_t = new Stack<>();
        char[] chars_s = S.toCharArray();
        char[] chars_t = T.toCharArray();
        for (char s : chars_s) {
            if (s == '#') {
                if (!stack_s.empty()) {
                    stack_s.pop();
                }

            }  else{
                stack_s.push(s);
            }
        }
        for (char t : chars_t) {
            if (t == '#'){
                if (!stack_t.empty()) {
                    stack_t.pop();
                }

            }
            else{
                stack_t.push(t);
            }
        }


        while (!stack_s.empty() && !stack_t.empty()) {
            if (stack_s.peek()!=stack_t.peek()) {
                break;
            }
            stack_s.pop();
            stack_t.pop();
        }

        if (stack_s.empty() && stack_t.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution21 solution21=new Solution21();
        String S="xywrrmp";
        String T="xywrrmu#p";
        System.out.println(solution21.backspaceCompare(S,T));
    }
}
