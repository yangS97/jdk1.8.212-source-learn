package cn.ys.test.thread.locks;

/**
 * @author YS
 * @date 2023/8/22 17:26
 * @Description
 */
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    private Thread thread1;
    private Thread thread2;


    public static void main(String[] args) {
        LockSupportTest lockSupportTest = new LockSupportTest();
        lockSupportTest.startThreads();
    }

    public void startThreads() {
        thread1 = new Thread(() -> {
            System.out.println("Thread 1 is waiting for Thread 2 to unpark it");
            LockSupport.park();
            System.out.println("Thread 1 has been unparked by Thread 2");
        });

        thread2 = new Thread(() -> {
            System.out.println("Thread 2 is sleeping for 2 seconds");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 is unparking Thread 1");
            LockSupport.unpark(thread1);
        });

        thread1.start();
        thread2.start();
    }
}
