package testng;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class TestngFactory {

	public TestngFactory(){
		System.out.println("333333333333333");
	}

	@BeforeSuite
	public void init(){
		System.out.println("222222222222");
	}

	@DataProvider(name = "datasource")
	public Object[][] getDatasource() {
		return new Object[][] { new Object[] { 2 } };
	}
	
	@Factory(dataProvider = "datasource")
	public Object[] createInstances(int a) throws NoSuchFieldException, IllegalAccessException {
		System.out.println("11111111111111");
		Object[] result = new Object[a];
		for (int i = 0; i < a; i++) {
			result[i] = new TestngFactoryTest(i * 10);
		}
//		Field f=ClassLoader.class.getDeclaredField("classes");
//		f.setAccessible(true);
//		Vector classes=(Vector)f.get(ClassLoader.getSystemClassLoader());
//		classes.stream().forEach(t-> System.out.println(t));

		return result;
	}



}
