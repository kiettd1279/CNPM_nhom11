package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Profile_Modal {
//	assign http request to the facebook graph api 
	public Profile_Bean call_me(String access_token) throws Exception {
//		using the URL below to request to graph Facebook 
	     String url = 
	    		 "https://graph.facebook.com/v3.3/me?fields=id%2Cname%2Cemail&access_token=EAAhSmWIVZAzcBADQcKfgLGHevWZCsKOitOODPELfkw2YHsx8eRZAaN5ZBIebu2dQYJO9VXZCKnFECyAZBwgiFXhBZC3j0VeK7fEcwcoIur1TZAdYzsFH0O6mcPyaVz7kb8DjJz6GlfpDeExqUbveZA0vvc4n3qZBH9hcZCIpgVXGplsYBpq75ThTtZCdZB4rJ6mNnscKFyneycbnqcwZDZD";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     System.out.println(response);
	     Profile_Bean obj_Profile_Bean=new Profile_Bean();
	     JSONObject myResponse = new JSONObject(response.toString());
	     obj_Profile_Bean.setUser_name(myResponse.getString("name"));
	     obj_Profile_Bean.setId(myResponse.getString("id"));
	     obj_Profile_Bean.setEmail(myResponse.getString("email"));
	

	    
		return obj_Profile_Bean;
	   }
//	public static void main(String[] args) {
//		try {
//			Profile_Modal modal = new Profile_Modal();
//			modal.call_me();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
	//}
}