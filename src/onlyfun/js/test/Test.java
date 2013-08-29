package onlyfun.js.test;

import onlyfun.js.model.Company;
import onlyfun.js.reflect.Reflect;

public class Test {
	public static void main(String[]args) {
//		String str = "getId";
//		System.out.println(str.substring(3, str.length()));
		Reflect r = new Reflect();
		Company c = new Company();
		c.setDescription("description");
		c.setName("name");
		String sql = r.getSaveSql2(c);
		System.out.println(sql);
	}
}
