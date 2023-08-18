package cn.ys.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YS
 * @date 2023/8/17 16:47
 * @Description
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //synchronizedMethod();
        lockMethod();
    }

    private static void lockMethod() {
        LockTicket lockTicket = new LockTicket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                lockTicket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 70; i++) {
                lockTicket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                lockTicket.sale();
            }
        }, "C").start();
    }

    private static void synchronizedMethod() {
        SynchronizedTicket synchronizedTicket = new SynchronizedTicket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                synchronizedTicket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 70; i++) {
                synchronizedTicket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                synchronizedTicket.sale();
            }
        }, "C").start();
    }
}

class SynchronizedTicket {
    private int number = 50;

    // synchronized 本质就是锁
    public synchronized void sale() {
        if (number > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sale " + number-- + " other " + number);
        }
    }
}

class LockTicket {
    private int number = 50;
    //默认非公平锁
    private Lock lock =  new ReentrantLock();
    // 公平锁     private Lock lockTicket =  new ReentrantLock(true);

    public synchronized void sale() {
        lock.lock();
        try {
            if (number > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " sale " + number-- + " other " + number);
            }
        } finally {
            lock.unlock();
        }
    }
}
