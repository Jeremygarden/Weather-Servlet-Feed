<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=#90EE90>

<% 
    
    String info = (String) request.getAttribute("info") ; 
   
    System.out.println(info);
    String[] infos = info.split("#"); 
%>
<table border="1" align="center" bgcolor=#8DEEEE>
     <tr>
     <td colspan="12">
     <strong><font color="blue"><h2>weather forecast</h2></font></strong></td></tr>
     <tr>
     <td>
     <font color="blue">
     Date &nbsp;&nbsp;<%=infos[0]%>&nbsp;&nbsp;&nbsp;</td>
     
     <tr>
     <td>Wind Direction &nbsp;&nbsp;<%=infos[1]%>
     </td></tr> 
     <tr>
     <td> <font color="blue">Day Temprature&nbsp;&nbsp;<%=infos[2]%> </font></td></tr>
     
     <tr>
     <td> <font color="blue">Night Temprature&nbsp;&nbsp;<%=infos[3]%> </font></td></tr>
     
     <tr>
     <td>Cloud&nbsp;&nbsp;<%=infos[4]%></td></tr>
     
     </font></table>
<div margin-top:100px; font-size:15px; face="Verdana" align="center">     
<p> The Statistics Is Orginated <a href="url">From Openweathermap.org</a></p>
</div>     
</body>
</html>