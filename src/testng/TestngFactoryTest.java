package testng;

import org.testng.annotations.Test;

public class TestngFactoryTest {
	public int m_numberOfTimes;

	public TestngFactoryTest(int numberOfTimes) {
		this.m_numberOfTimes = numberOfTimes;
	}

	public static int num;

	@Test
	public void testServer() {
		num++;
		System.out.println("num    " + num + "  m_numberOfTimes ："
				+ m_numberOfTimes);
	}
}
