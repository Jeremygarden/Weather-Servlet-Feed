<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">


<title>Weather Search Engine</title>
</head>
  <body bgcolor=#FFA500>
  <div  width:300px
        height:300px align="center" >
  
  <form action="WeatherServlet" method="get" >
   <h2>Welcome! Weather Search Engine</h2>
   	<p>Find your city:</p>
   	<label><input type="text" id="city" name="city"/></label>
   	<p><input type="submit" value="search" /></p>
   	
   	</form>
   	<form action="WeatherHistory" method="get" >
   	<p><input type="submit" value="view history" /></p>
   	</form>
  </div>
  </body>
</html>

