package com.lmx.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.lmx.util.WeatherInfo;
/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
       
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String city = request.getParameter("city") ;
		String info = WeatherInfo.getWeather(city) ;
		request.setAttribute("info", info);
		System.out.println("servelt"+info);
		getServletContext().getRequestDispatcher("/WeatherInfo.jsp").forward(request, response);
		//request.getRequestDispatcher("WeatherInfo.jsp").forward(request, response); 
		
		
		Connection conn = null;	
		PreparedStatement ps = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/weather","root","root");
	      String sql="insert into weathercity(name,info) values(?,?)"; 
	      ps=conn.prepareStatement(sql);
	       
	      ps.setString(1, city);
	      ps.setString(2, "Date"+info);

	      ps.execute(); 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	    }finally{ 
	      if(ps!=null){try{ps.close();}catch(Exception e){}} 
	      if(conn!=null){try{conn.close();}catch(Exception e){}} 
	    }
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
