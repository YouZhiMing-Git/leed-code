package com.youzm.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo1 {
    public Foo1() {

    }
    private volatile  int x=1;
    private final Object lock=new Object();
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            // printFirst.run() outputs "first". Do not change or remove this line.
            while (x!=1)lock.wait();
            printFirst.run();
            x=2;
            lock.notifyAll();
        }



    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (x!=2)lock.wait();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            x=3;
            lock.notifyAll();
        }


    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while (x!=3)lock.wait();
            // printThird.run() outputs "third". Do not change or remove this line.

        }
        printThird.run();
    }
}
