package org.mule.modules.sunrisesunset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.sunrisesunset.config.ConnectorConfig;

@Connector(name="sunrisesunset", friendlyName="Sunrisesunset")
public class SunrisesunsetConnector {

	@Config
    ConnectorConfig config;
	private final String sunrise = "https://api.sunrise-sunset.org/json?";

	private final String USER_AGENT = "Mozilla/5.0";
		
	   	private  URL url;


	   	HttpURLConnection con ;

	       
	       public ConnectorConfig getConfig() {
	           return config;
	       }

	       public void setConfig(ConnectorConfig config) {
	           this.config = config;
	       }
	       
	       

	       @Processor
	       public String searchOnLocation(String lng,String lat) {
	           String response;
	       	try {
	       		
	       		String reqStr=sunrise+"lng="+lng+"&lat="+lat;
	       		
	       		url  = new URL(reqStr);
	      	response=processConnection(url);
	   		} catch (MalformedURLException e) {
	   			response="Error connecting to endpoint Please retry";
	   			e.printStackTrace();
	   		}
	       	catch (Exception e) {
	       		response="Error connecting to endpoint Please retry" ;  				
	   			e.printStackTrace();
	   		}
	       	return response;
	     

	       }
	       
	      
	       
	       private String processConnection(URL url){
	       	
	       	StringBuffer response = new StringBuffer();
	       	
	       	try {
	   			con = (HttpURLConnection) url.openConnection();
	   			con.setRequestProperty("User-Agent", USER_AGENT);
	   			
	   			con.setRequestMethod("GET");

	   			// add request header
	   			int responseCode = con.getResponseCode();
	   			System.out.println("\nSending 'GET' request to URL : " + url);
	   			System.out.println("Response Code : " + responseCode);

	   			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	   			String inputLine;
	   			

	   			while ((inputLine = in.readLine()) != null) {
	   				response.append(inputLine);
	   			}
	   			in.close();
	   		}  catch (Exception e) {
	   			response=new StringBuffer("Error getting info");
	   			e.printStackTrace();
	   		}

	   		// print result
	   		return response.toString();
	       }

}