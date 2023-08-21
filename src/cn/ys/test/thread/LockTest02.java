package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/18 9:18
 * @Description
 */

import java.util.concurrent.TimeUnit;

/**
 * 3、增加了一个普通方法 先打印sendMessage还是hello 1/sendMessage 2/hello
 * 4、两个对象，两个同步方法，发短信还是电话  1/callMessage 2/sendMessage 不同的锁，对象不一样，就看执行的时间
 */
public class LockTest02 {
    public static void main(String[] args) throws Exception {
        // 两个对象
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
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

class Phone2 {
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

    // 这里没有锁，不受锁的影响
    public void hello() {
        System.out.println("Phone2.hello");
    }
}
