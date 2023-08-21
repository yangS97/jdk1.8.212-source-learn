package cn.ys.test.functionInterface.function;

import java.util.function.Predicate;

/**
 * @author YS
 * @date 2023/8/21 10:10
 * @Description 断言型函数式接口测试
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate predicate = new Predicate(){
            /**
             * Evaluates this predicate on the given argument.
             *
             * @param o the input argument
             * @return {@code true} if the input argument matches the predicate,
             * otherwise {@code false}
             */
            @Override
            public boolean test(Object o) {
                Integer i = Integer.valueOf(o.toString());
                return i >= 60;
            }
        };

        System.out.println("predicate = " + predicate.test(59));

        Predicate predicate02 = str -> {return str.equals("hello");};

        System.out.println("predicate02 = " + predicate02.test("helo"));
    }
}
