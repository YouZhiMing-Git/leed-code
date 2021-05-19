package com.youzm.stack;

import java.util.Stack;

public class Solution26 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int n=T.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            while (!stack.empty()){
                if(T[i]<=T[stack.peek()]){
                    break;
                }
                result[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
