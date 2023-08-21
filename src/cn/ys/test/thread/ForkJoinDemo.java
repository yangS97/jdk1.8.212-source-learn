package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/21 10:38
 * @Description
 */

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 求和计算的任务、
 * 如何使用 forkJoin
 * 1、forkjoinpool 通过它来执行
 * 2、计算任务 execute(ForkJoinTask<?> task)
 * 3、计算类必须继承 ForkJoinTest
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    // 临界值
    private long temp = 1000L;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    // 计算方法

    @Override
    protected Long compute() {
        Long sum = 0L;
        if ((end - start) < temp) {
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // 分支合并计算
            long middle = (start + end) / 2;
            ForkJoinDemo forkJoin1 = new ForkJoinDemo(start, middle);
            // 拆分任务 把任务压入线程队列
            forkJoin1.fork();
            ForkJoinDemo forkJoin2 = new ForkJoinDemo(middle + 1, end);
            // 拆分任务 把任务压入线程队列
            forkJoin2.fork();
            return forkJoin1.join() + forkJoin2.join();
        }
    }
}

class ForkJoinTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 普通程序员
     * <p>
     * sum = 500000000500000000 时间：7134 ms
     */
    public static void test1() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + " 时间：" + (end - start) + " ms");
    }

    /**
     * 中级程序员
     * <p>
     * sum = 500000000500000000 时间：3859 ms
     */
    public static void test2() {
        long start = System.currentTimeMillis();
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1, 10_0000_0000);
//        forkJoinPool.execute(forkJoinDemo);
//        Long sum = 0L;

        Long sum = forkJoinDemo.compute();
//
//        try {
//            sum = forkJoinDemo.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + " 时间：" + (end - start) + " ms");

    }

    /**
     * 高级程序员
     *
     * sum = 500000000500000000 时间：830 ms
     */
    public static void test3() {
        long start = System.currentTimeMillis();
        // Stream 并行流
        long sum = LongStream
                .rangeClosed(0L, 10_0000_0000L)
                .parallel()
                .reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + " 时间：" + (end - start) + " ms");

    }
}
