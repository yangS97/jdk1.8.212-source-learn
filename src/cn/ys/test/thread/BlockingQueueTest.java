package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/18 17:17
 * @Description  BlockingQueue
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10); // 创建BlockingQueue，设置容量为10

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    queue.put(i); // 插入元素
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000); // 模拟生产的时间
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    int value = queue.take(); // 获取元素
                    System.out.println("Consumed: " + value);
                    Thread.sleep(2000); // 模拟消费的时间
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
