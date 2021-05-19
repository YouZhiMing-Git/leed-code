package com.youzm.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers1 {
    public DiningPhilosophers1() {

    }


    //五个勺子 五把锁
    private ReentrantLock[] forks= {new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock(),new ReentrantLock()};
    //信号量
    private Semaphore semaphore=new Semaphore(4);
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork=philosopher;
        int rightFork=(philosopher+1)%5;

        if(philosopher%2==0){
            forks[leftFork].lock();
            forks[rightFork].lock();
        }else {
            forks[rightFork].lock();
            forks[leftFork].lock();
        }
        semaphore.acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();


        forks[rightFork].unlock();
        forks[leftFork].unlock();
        semaphore.release();


    }
}
