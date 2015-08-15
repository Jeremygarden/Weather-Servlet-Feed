package com.lmx.util;

import java.io.InputStream;





import java.net.URI;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;




public class WeatherInfo {

	
	public static String getWeather(String city){
		
		try{
		HttpClient httpClient = HttpClients.createDefault();
		String openURL ="http://api.openweathermap.org/data/2.5/forecast/daily?q=city&mode=xml&units=metric&cnt=7"
				
		+"9514a2dc1bcd389b18bfd9e618b1a62d";
		String url ="";

	    URI uri=new URIBuilder().setScheme("http")
	    		.setHost("api.openweathermap.org")
	    		.setPath("/data/2.5/forecast/daily")
	    		.setParameter("q", city)
	    		.setParameter("mode", "xml")
	    		.setParameter("units", "metric")
	    		.setParameter("cnt", "7")
	    		.setParameter("APPID","9514a2dc1bcd389b18bfd9e618b1a62d").
	    		build();
		HttpGet httpGet = new HttpGet(uri);
	    HttpResponse infoResponse = httpClient.execute(httpGet);
		HttpEntity entity = infoResponse.getEntity();
		
		InputStream in = entity.getContent();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(in);
		
		StringBuffer sb = new StringBuffer();
		
		NodeList timeNode = document.getElementsByTagName("time");
		sb.append(timeNode.item(0).getAttributes().item(0).getNodeValue()+"#");
      	NodeList windDirection  = document.getElementsByTagName("windDirection");
		sb.append(windDirection.item(0).getAttributes().item(2).getNodeValue()+"#");
			  	
		
		NodeList temperature  = document.getElementsByTagName("temperature");
		sb.append(temperature.item(0).getAttributes().item(0).getNodeValue()
					+"#"+temperature.item(0).getAttributes().item(3).getNodeValue()+"#");
			
			NodeList clouds  = document.getElementsByTagName("clouds");
			sb.append(clouds.item(0).getAttributes().item(0).getNodeValue()+"#");

		//	System.out.println("XML "+sb.toString());	
		return sb.toString();
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
	
}


