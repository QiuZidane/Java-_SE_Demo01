package Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	public void getDate_Old() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat();
		String date = dateFormat.format(now);
		System.out.println(date); // 17-1-19 下午4:18 -- 按本地时间规则格式化

		String s;
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		s = format1.format(new Date());
		System.out.println(s); // 2017-01-19 04:22:33

		DateFormat format2 = new SimpleDateFormat("yyyyMMddhhmmss");
		s = format2.format(new Date());
		System.out.println(s); // 20170119042233

		s = DateFormat.getDateInstance(DateFormat.FULL).format(now);
		System.out.println(s); // 2017年1月19日 星期四

		s = DateFormat.getDateInstance(DateFormat.SHORT).format(now);
		System.out.println(s); // 17-1-19

	}

	public void getCalendar() {
		GregorianCalendar now = new GregorianCalendar();

		long mi_second = now.getTimeInMillis();
		int day = now.get(Calendar.DATE);
		int month = now.get(Calendar.MONTH) + 1;
		int year = now.get(Calendar.YEAR);
		int hour = now.get(Calendar.HOUR);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);

		String formatTime = year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec;

		System.out.println(formatTime);
	}

	public static void main(String[] args) {

		DateTest dt = new DateTest();

		dt.getDate_Old();
		dt.getCalendar();

	}

}
