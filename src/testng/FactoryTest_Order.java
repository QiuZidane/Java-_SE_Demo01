package testng;

import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;

@Listeners(MethodInterceptor.class) // 通过拦截器重新给方法排序, 否则是乱序的
public class FactoryTest_Order {

    public FactoryTest_Order(){
        System.out.println("FactoryTest_Order");
    }

    @Factory
    public Object[] createInstance() {

        return new Object[]{
                new TestData().setName("Zidane").setOrder(1),
                new TestData().setName("Eva").setOrder(2),
                new TestData().setName("Jane").setOrder(3),
                new TestData().setName("Jack").setOrder(4)
        };
    }
}
