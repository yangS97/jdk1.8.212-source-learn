package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/21 13:59
 * @Description
 */
/**
 * 静态代理总结：
 * 静态代理模式，代理对象和真实对象都要实现同一个接口
 * 代理对象代理真实对象   这个是重点
 */
public class StaticProxy {
    public static void main(String[] args) {

        new Thread(() -> System.out.println("我爱你")).start();

        new WeddingMarry(new You()).happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

/**
 * 真实角色，你去结婚  (被代理对象代理)
 */
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("You.happyMarry");
    }
}

/**
 * 代理角色，帮助结婚
 */
class WeddingMarry implements Marry {

    // 真实目标角色
    private Marry target;

    public WeddingMarry(Marry target) {
        this.target = target;
    }


    private void before() {
        System.out.println("WeddingMarry.before");
        System.out.println("结婚之前的准备");
    }


    private void after() {
        System.out.println("WeddingMarry.after");
        System.out.println("结婚之后的收拾");
    }

    @Override
    public void happyMarry() {
        this.before();
        this.target.happyMarry();
        this.after();
    }
}
