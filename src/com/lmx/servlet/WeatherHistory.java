package com.lmx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmx.util.WeatherInfo;

/**
 * Servlet implementation class WeatherHistory
 */
@WebServlet("/WeatherHistory")
public class WeatherHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
		//String city = request.getParameter("city") ;
		//String info = WeatherInfo.getWeather(city) ;
        PrintWriter out = response.getWriter();
		Connection con = null;
		ResultSet result = null;
	    Statement st = null;
	    
	    out.println("<table border=1>");
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/weather","root", "root");
            st = con.createStatement();

            result = st.executeQuery("select * from weathercity");
            while(result.next()){
            	//getServletContext().getRequestDispatcher("/JDBC.jsp").forward(request, response);
            	out.println("<tr><td>"
            			+ result.getString("name")+"</td></tr>");
            	out.println("<tr><td>"
            			+ result.getString("info")+"</td></tr>");
            	
            	
            }
                out.println("</table>");
            } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }catch(Exception e){

            }finally{
            if(result!=null){
            
            try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            } 
            result = null;
            }
            if(st!=null){
            try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
            st = null;
            
            if(con!=null){
            try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
            con = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
