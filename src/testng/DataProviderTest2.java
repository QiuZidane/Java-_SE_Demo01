package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyListener.class})
public class DataProviderTest2 {

    @DataProvider(name = "dp1")

    public Object[][] dp() {

        Object[] o1 = new Object[]{"xx23","233"};
        Object[] o2 = new Object[]{"12223","xx233"};
        return new Object[][]{o1,o2};
    }

    @Test
    public void test1() {
        System.out.println("run test1 ");
    }

    @Test(dataProvider = "dp1")
    public void test2(Object[] o) {

//        System.out.println("access time = " + times);

    }


}
