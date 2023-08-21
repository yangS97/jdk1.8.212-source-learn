package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/18 14:23
 * @Description
 */

import java.util.concurrent.TimeUnit;

/**
 * 7. 一个静态的同步方法，1个普通的同步方法，1个对象，先打印发短信还是打电话？
 * 8、一个静态的同步方法，1个普通的同步方法，2个对象，先打印发短信还是打电话？
 */
public class LockTest04 {
    public static void main(String[] args) throws Exception {
        // 两个对象
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();
        // 锁的存在
        new Thread(() -> {
            phone1.sendMessage();
        }, "A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            phone2.callMessage();
        }, "B").start();
    }
}

class Phone4 {

    // 锁的是Class
    public static synchronized void sendMessage() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Phone.sendMessage");
    }

    // 锁的是对象
    public synchronized void callMessage() {
        System.out.println("Phone.callMessage");
    }
}
