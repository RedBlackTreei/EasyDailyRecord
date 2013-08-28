package onlyfun.js.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class Reflect {

	private String cls;

	public Reflect(String cls) {
		this.cls = cls;
	}
	
	public Reflect() {
		
	}
		
	public String getSaveSql(Object obj) {
		Class<?> object = obj.getClass();
		String className = object.getName();
		String tableName = this.getTableName(className);
		String sqlHead = "insert into " + tableName + "(";
		Method[] methods = this.getMethods(object);
		if(StringUtils.isEmpty(tableName)) {
			return StringUtils.EMPTY;
		}
		List<String> fieldNames = new ArrayList<String>();
		List<Object> fieldValues = new ArrayList<Object>();
		for(Method method : methods) {
			String methodName = method.getName();
			if(methodName.startsWith("get") && !methodName.startsWith("getClass")) {
				String fieldName = methodName.substring(3, methodName.length());
				fieldNames.add(fieldName);
				try {
					Object fieldValue = method.invoke(obj);
					if(fieldValue instanceof String) {
						fieldValues.add("\"" + fieldValue + "\"");
					} else {
						fieldValues.add(fieldValue);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		String sql = this.generateSql(sqlHead, fieldNames, fieldValues);
		return sql;
	}
	
	private String generateSql(String sqlHead, List<String> fieldNames, List<Object> fieldValues) {
		String sql = sqlHead;
		for (int i = 0; i < fieldNames.size(); i++) {  
            if (i < fieldNames.size() - 1) {  
            	sql += fieldNames.get(i) + ",";  
            } else {  
            	sql += fieldNames.get(i) + ") values(";  
            }  
        }  
        for (int i = 0; i < fieldValues.size(); i++) {  
            if (i < fieldValues.size() - 1) {  
            	sql += fieldValues.get(i) + ",";  
            } else {  
            	sql += fieldValues.get(i) + ")";  
            }  
        }
        return sql;
	}
	
	private Method[] getMethods(Class<?> cls) {
		Method[] methods = cls.getMethods();
		if(ArrayUtils.isEmpty(methods)) {
			return (Method[])ArrayUtils.EMPTY_OBJECT_ARRAY;
		}
		return methods;
	}
	
	private String getTableName(String className) {
		if(StringUtils.isEmpty(className)) {
			return StringUtils.EMPTY;
		}
		String tableName = className.substring(className.lastIndexOf(".") + 1, className.length()).toLowerCase();
		return tableName;
	}

	public String[] getFieldNames(Field[] fields) {
		String[] names = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			names[i] = fields[i].getName();
		}
		return names;
	}
	
	public Class<?> getCls() {
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
