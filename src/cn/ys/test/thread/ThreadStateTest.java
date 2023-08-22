package cn.ys.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author YS
 * @date 2023/8/22 9:55
 * @Description
 */
public class ThreadStateTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            System.out.println("Task running in thread: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            return "Task completed";
        };

        FutureTask<String> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);

        System.out.println("Thread state: " + thread.getState());

        thread.start();
        System.out.println("Thread state: " + thread.getState());

        String result = futureTask.get();
        System.out.println("Thread state: " + thread.getState());
        System.out.println("Result: " + result);
    }
}
