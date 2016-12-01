package com.demo;

import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import inheritance.Employee;

public class MyClass1 {

	@Override
	public String toString() {

		String str1 = "ABC";

		// TODO Auto-generated method stub
		String s = String.format("string2=%s and %s", string2, str1);
		return s;
	}

	{
		System.out.println("hello1!");
	}

	private static String string2 = "string2";

	static {
		System.out.println("hello2!");
		MyClass1.string2 = "string2 init done";
	}

	private String string1 = "abc";

	/**
	 * @author QiuZidane
	 *         <h2>MyClass1的构造方法</h2>
	 * @param int1
	 *            TODO
	 * 
	 * @see <a href="www.baidu.com">BaiDu一下</a>
	 */
	MyClass1(String initString, int int1) {

		this.string1 = "ddd";

	}

	// 构造方法 -> 等同于 public static MyClass1() 或者 MyClass1()
	public MyClass1() {
		// TODO Auto-generated constructor stub
	}

	protected void about_array() {
		int[] intarr1 = new int[10];
		intarr1[0] = 1;
		System.out.println(Arrays.toString(intarr1));

		String[] strarr1 = new String[10];
		for (int i = 0; i < strarr1.length; i++) {
			strarr1[i] = "哈哈";
		}

		System.out.println(Arrays.toString(strarr1));

		String[] strarr2 = Arrays.copyOf(strarr1, 5);
		System.out.println(Arrays.toString(strarr2));

		// int[] intarr2 = Arrays.copyOf(intarr1, 5);
		int[] intarr2 = intarr1.clone();
		System.out.println(Arrays.toString(intarr2));

		ArrayList<String> list = new ArrayList<>(10);
		int i = 0;
		while (i < 10) {
			list.add("A");
			i++;
		}
		String[] arrlist = new String[list.size()];
		list.toArray(arrlist);
		System.out.println(list);
		System.out.println(Arrays.toString(arrlist));
	}

	/**
	 * 用于测试字符串相关知识点
	 */
	private void about_string() {

		System.out.println("string1 = " + this.string1);
		String formatString = String.format("string1 = %s", this.string1);
		System.out.println(formatString);

		StringBuffer sb1 = new StringBuffer("StringBuffer=");
		sb1.append("aaa");
		sb1.append(" bbb");
		sb1.append('d');
		System.out.println(sb1);

		StringBuilder sbu1 = new StringBuilder("StringBuilder=");
		sbu1.append("123");
		sbu1.append(" ddd");
		sbu1.delete(1, 3);
		System.out.println(sbu1);

	}

	/**
	 * 
	 * @param datestr
	 *            日期
	 */
	public void about_date() {
		Date myDate = new Date();
		// Date myDate2 = new Date(99, 2, 2);

		// 使用toString()函数显示日期时间
		System.out.println(myDate.toString());
		// System.out.println(myDate2.getTime());

		Date myDate3 = new Date(990304000000l);

		System.out.println(myDate3.toString());
		// System.out.println(myDate.before(myDate2));

		try {
			long begin = System.currentTimeMillis();

			Thread.sleep(10);

			long end = System.currentTimeMillis();

			System.out.println(end - begin);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		GregorianCalendar now = new GregorianCalendar();
		System.out.println("gregor=" + now);
		int month = now.get(Calendar.MONTH) + 1;
		System.out.println("month = " + month);

		System.out.println(DateFormatSymbols.getInstance().getShortWeekdays()[Calendar.DATE]);
		System.out.println(Calendar.DATE);

	}

	private void about_decimal() {

		BigDecimal bd1 = new BigDecimal(2.0);
		BigDecimal bd2 = new BigDecimal(1.1);
		BigDecimal bd3 = bd1.subtract(bd2);
		System.out.println("bd1=" + bd1);
		System.out.println("bd2=" + bd2);
		System.out.println(bd3);

		BigDecimal a = BigDecimal.valueOf((long) 2.0);
		BigDecimal b = BigDecimal.valueOf((long) 1.1);
		System.out.println("a-b=" + a.subtract(b));

	}

	public void about_arrayList() {
		ArrayList<Employee> staff = new ArrayList<Employee>();
		System.out.printf("staff.size()=%d \n", staff.size());
		staff.add(new Employee("Zidane", 60000, 2005, 7, 4));
		System.out.printf("staff.size()=%d \n", staff.size());
		staff.trimToSize(); // 调整存储区域大小，调整后再次添加元素的话，要花时间再次移动存储块
		staff.add(new Employee("Zidane", 60000, 2005, 7, 4));
		System.out.printf("staff.size()=%d \n", staff.size());
		System.out.println(staff.get(0).getName());
		staff.set(0, new Employee("Even", 7000, 2008, 7, 1));
		System.out.println(staff.get(0).getName());
	}

	/**
	 * @枚举类
	 * @author QZidane
	 *
	 */
	public enum Size {
		SMALL("S"), MEDIUM("M"), LARGE("L");
		private String abbr;

		private Size(String abbr) {	//默认私有/必须私有，只提供给枚举项使用 
			this.abbr = abbr;
		}

		public String getAbbr() {
			return abbr;
		}

	};
	
	public void about_enum(){
		Size s = Enum.valueOf(Size.class, "SMALL");//获得字符串"SMALL"对应的Size值
		System.out.println(s);//SMALL
		System.out.println(Size.SMALL.toString());//SMALL
		System.out.println(Size.SMALL.getDeclaringClass());
		System.out.println(Size.SMALL == Size.SMALL);
		Size[] values = Size.values();
		System.out.println(Arrays.toString(values)); //[SMALL, MEDIUM, LARGE]

	}

	public static void main(String... args) {

		MyClass1 mc1 = new MyClass1("abc", 123);

		// mc1.about_arrayList();
		//mc1.about_array();
		mc1.about_enum();
		// mc1.about_string();
		// mc1.about_date();
		// mc1.about_decimal();
		// mc1.about_array();


	}

}
