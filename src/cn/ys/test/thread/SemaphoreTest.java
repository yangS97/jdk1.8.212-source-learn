package cn.ys.test.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author YS
 * @date 2023/8/18 14:52
 * @Description
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
