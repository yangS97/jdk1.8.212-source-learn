package cn.ys.test.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author YS
 * @date 2023/8/21 10:50
 * @Description
 */
public class FutureTest {
    public static void main(String[] args) {
        try {
            // 发起一个请求
            // 没有返回值的异步回调 runAsync
            // 有返回值的异步回调 supplyAsync
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("???");

            });
            System.out.println(111);
            System.out.println(voidCompletableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
