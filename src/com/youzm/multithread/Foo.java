package com.youzm.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我们提供了一个类：
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 */
public class Foo {
    public Foo() {

    }

    private AtomicInteger firstJobDone=new AtomicInteger(0);
    private AtomicInteger secondeJobDone=new AtomicInteger(0);
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get()!=1){

        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondeJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondeJobDone.get()!=1){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
