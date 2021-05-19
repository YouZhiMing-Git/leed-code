package com.youzm.other;

import java.util.Stack;

/*
* 实现一个MyQueue类，该类用两个栈来实现一个队列
* */
public class MyQueue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();



    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.size()+stack1.size()==0;
    }

    public static void main(String[] args) {

        MyQueue queue=new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.peek();  // 返回 1
        queue.pop();   // 返回 1
        queue.empty(); // 返回 false


    }
}
