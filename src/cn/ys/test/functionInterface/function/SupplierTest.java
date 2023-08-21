package cn.ys.test.functionInterface.function;

import java.util.function.Supplier;

/**
 * @author YS
 * @date 2023/8/21 10:19
 * @Description
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier supplier = () -> {return "hello";} ;

        System.out.println("supplier = " + supplier.get());


    }
}
