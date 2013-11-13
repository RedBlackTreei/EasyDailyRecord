package junit;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import onlyfun.js.model.Department;
import onlyfun.js.reflect.Reflect;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReflectTest {
	
	private Reflect r = null;
	
	@Before
	public void setUp() throws Exception {
		r = Reflect.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		r = null;
	}

	@Test
	public void testGetSaveSql() {
		fail("尚未实现");
	}

	@Test
	public void testGetDeleteSqlObject() {
		fail("尚未实现");
	}

	@Test
	public void testGetDeleteSqlClassOfQLong() {
		fail("尚未实现");
	}

	@Test
	public void testGetQuerySql() {
		fail("尚未实现");
	}

	@Test
	public void testToObject() {
		r.toObject(Department.class);
	}

	@Test
	public void testGetSaveSql2() {
		fail("尚未实现");
	}

	@Test
	public void testGetInstance() {
		fail("尚未实现");
	}
	
	@Test
	public void testArray() {
		Object[] ids = {1,2,3};
		String[] strs = (String[])ids;
		for(String str:strs) {
			System.out.println(str);
		}
	}
	
	@Test
	public void testDate() {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		Date date = new Date();
//		String dateStr = format.format(date);
//		try {
//			Date d = format.parse(dateStr);
//			System.out.println(d);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		Date dd = this.dateToDate(new Date(), "yyyy-MM-dd HH:mm");
		System.out.println(dd);
//		System.out.println(dateStr);
	}
	
	/**
	 * 将字符串转换成日期类型
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date strToDate(String dateStr, String formatStr) {
		DateFormat dd = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 日期间相互转换
	 */
	public static Date dateToDate(Date date,String formatStr) {
		String dateStr = dateToStr(date, formatStr);
		Date d = strToDate(dateStr, formatStr);
		return d;
	}
	
	/**
	 * 将日期转换成字符串
	 * @param date
	 * @return
	 */
	public static String dateToStr(Date date, String formatStr) {
		if(date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		String str = format.format(date);
		return str;
	}

}
