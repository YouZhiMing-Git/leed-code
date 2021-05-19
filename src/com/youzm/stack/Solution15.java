package com.youzm.stack;

import java.util.Stack;

public class Solution15 {
    public int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int value;
        for (String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            }
            else if (op.equals("D")) {
                value = stack.peek() * 2;
                stack.push(value);
            }
            else  if (op.equals("+")) {
                int temp = stack.pop();
                value = stack.peek() + temp;
                stack.push(temp);
                stack.push(value);
            } else {
                value = Integer.parseInt(op);
                stack.push(value);
            }
        }
        while (!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution15 solution15=new Solution15();
        String[] strs={"5","2","C","D","+"};
        System.out.println(solution15.calPoints(strs));
    }
}
