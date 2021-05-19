package com.youzm.multithread;

/**
 * 哲学家进餐问题
 */
public class DiningPhilosophers {
    public DiningPhilosophers() {

    }
    private volatile boolean[] forks=new boolean[5];
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork=philosopher;
        int rightFork=(philosopher+1)%5;
        synchronized (this){
            while (forks[leftFork]||forks[rightFork]) this.wait();
            forks[leftFork]=true;
            forks[rightFork]=true;
        }
        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        synchronized (this){
            forks[leftFork]=false;
            forks[rightFork]=false;
            this.notifyAll();
        }
    }
}
