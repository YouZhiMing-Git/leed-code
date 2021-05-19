package com.youzm.multithread;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }
    //信号量
    private Semaphore fooSemaphore=new Semaphore(1);
    private Semaphore barSemaphore=new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}
