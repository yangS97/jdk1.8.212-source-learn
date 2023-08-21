package cn.ys.test.thread;

/**
 * @author YS
 * @date 2023/8/21 17:41
 * @Description
 */
// 定义一个接口，表示被装饰者
interface Component {
    void operation();
}

// 定义一个具体的被装饰者
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("执行具体的操作");
    }
}

// 定义一个装饰者抽象类，实现Component接口
abstract class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// 定义一个具体的装饰者
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("执行具体的装饰操作");
    }
}

// 测试代码
class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();

        System.out.println("-------------");

        Component decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
