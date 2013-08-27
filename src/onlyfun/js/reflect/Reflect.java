package onlyfun.js.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.jsp.jstl.sql.Result;

public class Reflect {

	private String cls;

	public Reflect(String cls) {
		this.cls = cls;
	}

	/**
	 * @Description :
	 * @param rs
	 * @param cls
	 * @return : void
	 */
	public void setValues(Result rs) {
		Class<?> demon = this.getCls();
		Field[] fields = demon.getDeclaredFields();
		String[] names = this.getFieldNames(fields);
		Class<?>[] paramTypes = new Class<?>[1];
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			StringBuffer sb = new StringBuffer();
			sb.append("set");
			sb.append(name.substring(0, 1).toUpperCase());
			sb.append(name.substring(1));
			try {
				Method method = demon.getMethod(sb.toString(), paramTypes);
				method.invoke(demon, rs.getRows().)
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
	}

	private String[] getFieldNames(Field[] fields) {
		String[] names = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			names[i] = fields[i].getName();
		}
		return names;
	}

	private Class<?> getCls() {
		Class<?> demon = null;
		try {
			demon = Class.forName(cls);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return demon;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}
}
