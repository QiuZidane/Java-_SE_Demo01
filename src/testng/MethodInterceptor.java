package testng;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

        Map<String,IMethodInstance> orders = new TreeMap<>(); // 有序map

        for (IMethodInstance instance : list) {
            TestData testData = (TestData) instance.getInstance();
            orders.put(String.valueOf(testData.getOrder()), instance);
        }

        List<IMethodInstance> orderList = new ArrayList<>(list.size());
        for (String order : orders.keySet()) { // 重新排序
            IMethodInstance test = orders.get(order);
            orderList.add(test);
        }
        return orderList; // TestNG会按这个返回的List内实例的顺序来执行
    }
}
