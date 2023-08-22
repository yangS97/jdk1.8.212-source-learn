package cn.ys.test.thread.tools;

/**
 * @author YS
 * @date 2023/8/22 16:14
 * @Description
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * CyclicBarrier是Java中的一个同步工具类，它用于等待一组线程达到一个共同的屏障点。CyclicBarrier类提供了一个await()方法，
 * 用于等待所有线程都到达屏障点。
 *
 * 当一个线程调用await()方法时，它会被阻塞，直到所有线程都调用了await()方法。当所有线程都调用了await()方法后，
 * 它们就会继续执行下去。CyclicBarrier类还提供了一个可选的Runnable参数，用于在所有线程都到达屏障点后执行一些操作。
 *
 * CyclicBarrier类的构造方法可以指定等待的线程数量和可选的Runnable参数。当所有线程都到达屏障点后，
 * Runnable参数中的代码会被执行一次。
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads have reached the barrier");
        });

        new Thread(() -> {
            try {
                System.out.println("Thread 1 is waiting at the barrier");
                barrier.await();
                System.out.println("Thread 1 has passed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Thread 2 is waiting at the barrier");
                barrier.await();
                System.out.println("Thread 2 has passed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Thread 3 is waiting at the barrier");
                barrier.await();
                System.out.println("Thread 3 has passed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
