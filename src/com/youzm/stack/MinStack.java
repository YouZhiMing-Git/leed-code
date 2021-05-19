package com.youzm.stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {


        dataStack.push(x);
        if(minStack.empty()||x<=minStack.peek()){
            minStack.push(x);
        }


    }

    public void pop() {
        if(minStack.peek()>=dataStack.peek()){
            minStack.pop();
        }
        dataStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
