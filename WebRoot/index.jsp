<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Timestamp"  %>
<%@ page import="onlyfun.js.utils.dao.DaoUtils" %>
<%@ page import="onlyfun.js.dao.impl.BaseDaoImpl" %>
<%@ page import="onlyfun.js.model.Company" %>
<%@ page import="onlyfun.js.model.Record" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>i&nbsp;  
    <%
    	SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	BaseDaoImpl bd = new BaseDaoImpl();
    	Record r = new Record();
    	java.util.Date date = new java.util.Date();
    	Date d = new Date(date.getTime());
    	Timestamp tt = new Timestamp(date.getTime());
    	r.setBeginDate(tt);
    	r.setCompletionDesc("Justin");
    	r.setEmployeeId(1L);
    	r.setEndDate(tt);
    	r.setIsFinished(true);
    	r.setNormalHours(4.0);
    	r.setOverTimeHours(2.0);
    	r.setPlanType("项目沟通");
    	int rows = bd.save(r);
    	out.println("rows = " + rows);
     %>
  </body>
</html>
