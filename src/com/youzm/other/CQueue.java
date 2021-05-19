package com.youzm.other;

import java.util.Stack;

public class CQueue {
    Stack<Integer> originStack=new Stack<>();
    Stack<Integer> tempStack=new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        originStack.push(value);
    }

    public int deleteHead() {
        if(!tempStack.isEmpty())return tempStack.pop();
        if(originStack.empty())return -1;
        while (!originStack.empty()){
            tempStack.push(originStack.pop());
        }
        return tempStack.pop();

    }

    public static class CustomStack {
       /* private int MAX_SIZE;
        private int cur_size=0;
        Stack<Integer> stack =new Stack<>();
        public CustomStack(int maxSize) {
            MAX_SIZE=maxSize;
        }

        public void push(int x) {
            if(cur_size<MAX_SIZE){
                stack.push(x);
                cur_size++;
            }
        }

        public int pop() {
            if(cur_size==0) return -1;
            cur_size--;
            return stack.pop();
        }

        public void increment(int k, int val) {
            Stack<Integer> helpStack=new Stack<>();
            int no_val=cur_size-k<0?0:cur_size-k;
            int i=0;
            while (!stack.empty()){
                if(i>=no_val){
                    helpStack.push(stack.pop()+val);
                }else {
                    helpStack.push(stack.pop());
                }
                i++;
            }
            while (!helpStack.empty()){
                stack.push(helpStack.pop());
            }
        }*/


        int[] data;
        int curIndex = 0;

        public CustomStack(int maxSize) {
            data = new int[maxSize];
        }

        public void push(int x) {
            if (curIndex < data.length) {
                data[curIndex++] = x;
            }
        }

        public int pop() {
            if (curIndex == 0) return -1;
            else return data[--curIndex];

        }

        public void increment(int k, int val) {
            int n=curIndex<k?curIndex:k;
            for(int i=0;i<n;i++){
                data[i]+=val;
            }
        }

        public static void main(String[] args) {
            CustomStack customStack=new CustomStack(3);
            customStack.push(1);
            customStack.push(2);
            System.out.println(customStack.pop());
            customStack.push(2);
            customStack.push(3);
            customStack.push(4);
            customStack.increment(5,100);
            customStack.increment(2,100);
            System.out.println(customStack.pop());
            System.out.println(customStack.pop());
            System.out.println(customStack.pop());

        }

    }
}
