package com.youzm.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();
    int top;
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size()>1){
            top=queue1.remove();
            queue2.add(top);
        }
        int result=queue1.remove();

        Queue<Integer> temp;
        temp=queue2;
        queue2=queue1;
        queue1=temp;
        return result;
    }

    /** Get the top element. */
    public int top() {
       return  top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
