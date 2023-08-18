package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/17 15:26
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        // 获取 CPU 的核数   实际上返回的是线程数量
        // CPU密集型 IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
