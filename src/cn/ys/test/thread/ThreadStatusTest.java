package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/21 14:37
 * @Description
 */
public class ThreadStatusTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("TestState.main");
        });

        // 观测状态
        Thread.State state = thread.getState();
        System.out.println(state);
        thread.start();
        state = thread.getState();
        System.out.println(state);
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100);
                state = thread.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
