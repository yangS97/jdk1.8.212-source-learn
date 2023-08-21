package cn.ys.test.functionInterface.function;

import java.util.function.Consumer;

/**
 * @author YS
 * @date 2023/8/21 10:16
 * @Description
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer consumer = (str) -> {
            System.out.println("str = " + str);
        };
        consumer.accept("hello");
    }
}
