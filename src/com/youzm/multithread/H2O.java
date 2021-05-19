package com.youzm.multithread;

import java.util.concurrent.Semaphore;

public class H2O {
    public H2O() {

    }

    private Semaphore hySemaphore=new Semaphore(2);
    private Semaphore oxySemaphore=new Semaphore(0);
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hySemaphore.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxySemaphore.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxySemaphore.release(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hySemaphore.acquire(2);
    }
}
