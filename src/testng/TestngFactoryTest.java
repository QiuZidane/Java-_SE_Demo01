package testng;

import org.testng.annotations.Test;

public class TestngFactoryTest {
    public int m_numberOfTimes;

    public TestngFactoryTest(int numberOfTimes) {
        this.m_numberOfTimes = numberOfTimes;
    }

    public static int num;

    @Test
    public void testServer1() {
        num++;
        System.out.println(
                "testServer1 : num " + num + " m_numberOfTimes ：" + m_numberOfTimes + " instance is " + this);
    }

    @Test
    public void testServer2() {
        System.out.printf("testServer2 : num=%s m_numberOfTimes=%s\n", num, m_numberOfTimes);
    }




}
