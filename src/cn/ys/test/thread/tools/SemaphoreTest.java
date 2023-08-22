package cn.ys.test.thread.tools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author YS
 * @date 2023/8/18 14:52
 * @Description
 * Semaphore是Java中的一个同步工具类，它用于控制同时访问某个资源的线程数量。Semaphore类提供了两个主要的方法：acquire()和release()。
 *
 * 当一个线程需要访问某个资源时，它首先需要调用acquire()方法获取一个许可证。如果此时已经没有许可证可用，那么线程就会被阻塞，直到有一个许可证可用为止。
 * 当线程访问完资源后，它需要调用release()方法释放许可证，以便其他线程可以继续访问该资源。
 *
 * Semaphore类的构造方法可以指定许可证的数量，也可以不指定，默认为1。如果许可证的数量为1，那么Semaphore类就可以用作互斥锁，
 * 实现线程的互斥访问。如果许可证的数量大于1，那么Semaphore类就可以用于控制同时访问某个资源的线程数量。
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 线程数量：停车位 限流
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    // semaphore.acquire(); 获得
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    // semaphore.release(); 释放
                    System.out.println(Thread.currentThread().getName() + " 抢到车位");
                    System.out.println(Thread.currentThread().getName() + " 离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i + 1)).start();
        }
    }
}
