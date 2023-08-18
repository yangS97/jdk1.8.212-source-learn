package cn.ys.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，就是关于锁的8个问题
 * 1、标准情况下 两个线程先打印 发短信还是打电话 1/发短信 2/打电话
 * 2、sendMessage 延迟4秒 两个线程先打印 发短信还是打电话  1/发短信 2/打电话
 *
 * 锁, 它是锁的对象, 是锁的调用这个带锁方法的对象
 */
public class LockTest {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        // 锁的存在
        new Thread(() -> {
            phone.sendMessage();
        }, "A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            phone.callMessage();
        }, "B").start();
    }
}


class Phone {
    // synchronized 锁的对象是方法的调用者
    // 两个方法用的是同一把锁，谁先拿到谁先执行
    // 而且synchronized 是独占锁
    public synchronized void sendMessage()  {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Phone.sendMessage");
    }

    public synchronized void callMessage() {
        System.out.println("Phone.callMessage");
    }
}
