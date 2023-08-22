package cn.ys.test.thread.locks;

/**
 * @author YS
 * @date 2023/8/22 17:19
 * @Description
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition是Java中的一个同步工具类，它是Lock接口的一部分，用于在多线程之间进行协调和通信。
 * Condition类提供了await()和signal()方法，用于线程的等待和唤醒。
 *
 * 当一个线程需要等待某个条件满足时，它可以调用await()方法将自己挂起。当另一个线程满足了这个条件后，
 * 它可以调用signal()方法唤醒等待的线程。
 *
 * Condition类的实现通常依赖于一个Lock对象。在使用Condition类时，我们需要先获取这个Lock对象，
 * 然后再调用Condition对象的await()和signal()方法。
 */
public class ConditionTest {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int count = 0;

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    conditionTest.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (count >= 10) {
                condition.await();
            }
            count++;
            System.out.println("Incremented count to " + count);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (count <= 0) {
                condition.await();
            }
            count--;
            System.out.println("Decremented count to " + count);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
