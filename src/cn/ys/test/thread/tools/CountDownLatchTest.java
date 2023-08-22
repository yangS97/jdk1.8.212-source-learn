package cn.ys.test.thread.tools;

/**
 * @author YS
 * @date 2023/8/22 16:19
 * @Description
 */
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是Java中的一个同步工具类，它用于等待一个或多个线程完成某个操作。CountDownLatch类提供了两个主要的方法：countDown()和await()。
 *
 * 当一个线程完成了某个操作后，它需要调用countDown()方法，以便通知CountDownLatch对象一个操作已经完成。当所有操作都完成后，
 * 调用await()方法的线程就会被唤醒，继续执行下去。
 *
 * CountDownLatch类的构造方法需要指定计数器的初始值，即需要等待的操作数量。每次调用countDown()方法都会将计数器减1，
 * 当计数器的值为0时，所有操作都已经完成，调用await()方法的线程就会被唤醒。
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println("Thread 1 has completed its operation");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2 has completed its operation");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Thread 3 has completed its operation");
            latch.countDown();
        }).start();

        latch.await();
        System.out.println("All threads have completed their operations");
    }
}
