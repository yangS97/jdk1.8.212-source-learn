package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/18 14:36
 * @Description
 */

import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java.lang.UnsupportedOperationException 并发修改异常
 *
 */
public class ListTest {
    public static void main(String[] args) {
        // 并发下 ArrayList是不安全的
        // 解决方案：
        // List<String> list = new Vector<>();
        // List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        // CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();

        // CopyOnWrite 写入时复制 COW思想 计算机程序设计领域的一种优化策略
        // 多个线程调用的时候，list 读取的时候，固定的，写入/ 覆盖
        // 在写入的时候避免覆盖，造成数据问题
        // CopyOnWriteArrayList 比 Vector 强在哪里？使用 Lock锁
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        //List list1 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list1.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list1);
            }, String.valueOf(i)).start();
        }
    }
}
