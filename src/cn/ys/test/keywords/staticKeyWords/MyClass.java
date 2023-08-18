package cn.ys.test.keywords.staticKeyWords;

/**
 * @author YS
 * @date 2023/8/15 16:09
 * @Description 测试static关键字
 */
public class MyClass {
    private static int count;

    //静态代码块最优先执行，且只执行一次
    static {
        count = 0;
        System.out.println("Static block executed.");
    }

    //构造方法每次创建对象都会执行
    public MyClass() {
        count++;
    }

    public int getCount() {
        return count;
    }


    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        MyClass obj3 = new MyClass();

        System.out.println("Count: " + obj1.getCount());
        System.out.println("Count: " + obj2.getCount());
        System.out.println("Count: " + obj3.getCount());
    }
}
