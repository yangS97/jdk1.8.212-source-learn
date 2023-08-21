package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/21 13:40
 * @Description
 */
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": 第" + i + "次run");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTest());
        thread.start();
    }
}
