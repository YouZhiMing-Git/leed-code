package com.youzm.stack;

import java.util.Stack;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int n=pushed.length;
        int j=0;
        for(int i=0;i<n;i++){
            stack.push(pushed[i]);
            while (!stack.empty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Solution31 solution31=new Solution31();
        int[] pushed={1,2,3,4,5};
        int[] poped={4,5,3,2,1};
        System.out.println(solution31.validateStackSequences(pushed,poped));
    }
}
