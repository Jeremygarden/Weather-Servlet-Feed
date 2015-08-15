<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page language="java" import="java.util.*"  %>
    <%@ page import ="java.sql.*" %>
    <%@ page import="com.mysql.jdbc.Driver" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  Connection conn = null;
  //加载数据库驱动类
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   //数据库连接URL
   String url="jdbc:mysql://127.0.0.1:3306/jsptest";
   //数据库用户名和密码
   String user="root";
   String  password="admin";
   //根据数据库参数取得一个数据库连接值
   conn =  DriverManager.getConnection(url,user,password);
   
   out.print("取得一个数据库连接:\n");
   out.print(conn.toString());
   
   
   
   %>
</body>
</html>