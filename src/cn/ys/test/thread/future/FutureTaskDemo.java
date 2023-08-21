package cn.ys.test.thread.future;

/**
 * @author YS
 * @date 2023/8/21 18:27
 * @Description
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个Callable对象
        Callable<Integer> callable = () -> {
            System.out.println("正在计算结果...");
            Thread.sleep(3000);
            return 1 + 2;
        };

        // 创建一个FutureTask对象，并将Callable对象作为参数传入
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // 启动一个线程来执行FutureTask
        new Thread(futureTask).start();

        // 等待FutureTask执行完毕，并获取结果
        Integer result = futureTask.get();

        // 输出结果
        System.out.println("result = " + result);
    }
}
