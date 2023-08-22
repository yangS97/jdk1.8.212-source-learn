package cn.ys.test.thread.tools;

/**
 * @author YS
 * @date 2023/8/18 17:45
 * @Description
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具类 Executors
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        //单个线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 创建一个固定大小的线程池
         ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        // 可伸缩的线程池
         ExecutorService executorService3 = Executors.newCachedThreadPool();
        // 创建一个大小无限的线程池
         ExecutorService executorService4 = Executors.newScheduledThreadPool(5);

        // 单个线程
        // ExecutorService service = Executors.newSingleThreadExecutor();

        // 可以伸缩的线程池
        // ExecutorService service = Executors.newCachedThreadPool();
        // 固定的线程池大小
        ExecutorService service = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 100; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
        // 线程池用完 线程池结束 关闭线程池
    }
}
