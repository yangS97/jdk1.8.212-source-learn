package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/21 13:44
 * @Description
 */
public class ThreadTest  extends  Thread{
    @Override
    public void run() {
        //十次循环输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadTest()).start();
    }
}
