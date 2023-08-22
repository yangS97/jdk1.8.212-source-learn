package cn.ys.test.thread.tools;

/**
 * @author YS
 * @date 2023/8/22 16:05
 * @Description
 */
import java.util.concurrent.Exchanger;

/**
 * 在这个例子中，我们创建了一个Exchanger对象，并在两个线程之间交换数据。第一个线程向Exchanger对象传递了字符串"Hello"，
 * 第二个线程向Exchanger对象传递了字符串"World"。当两个线程都调用了exchange()方法后，它们会交换数据，并输出对方线程传递过来的数据。
 *
 * 总的来说，Exchanger是Java中的一个同步工具类，它用于实现两个线程之间的数据交换。Exchanger类提供了一个exchange()方法，
 * 用于在两个线程之间交换数据。Exchanger类的使用非常简单，只需要创建一个Exchanger对象，然后在两个线程之间交换数据即可。
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                String data1 = "Hello";
                String data2 = exchanger.exchange(data1);
                System.out.println("Thread 1 received: " + data2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                String data1 = "World";
                String data2 = exchanger.exchange(data1);
                System.out.println("Thread 2 received: " + data2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
