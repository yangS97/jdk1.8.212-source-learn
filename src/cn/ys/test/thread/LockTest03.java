package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/18 14:19
 * @Description
 */

import java.util.concurrent.TimeUnit;

/**
 * 5、增加两个静态同步方法 只有一个对象 1/发短信 2/打电话
 * 6、增加两个静态同步方法 2个对象 1/发短信 2/打电话
 */
public class LockTest03 {
    public static void main(String[] args) throws Exception {
        // 两个对象
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();
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

// Phone3 唯一的一个 class 对象
class Phone3 {
    // synchronized 锁的对象是方法的调用者
    // static 静态方法
    // 类一加载就有了，锁的是Class对象
    // 所以此时两个对象是同一把锁，也就是Class，
    public static synchronized void sendMessage() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Phone.sendMessage");
    }

    public static synchronized void callMessage() {
        System.out.println("Phone.callMessage");
    }

}
