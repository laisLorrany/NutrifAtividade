package br.edu.ifpb.nutrif.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONObject;

import android.util.Log;

public class HttpService {

    // IP da máquina onde se encontra o servidor.
    private static final String URL_CONTEXT = "http://ladoss.com.br:8443/nutrif/NutrIF_service/";

    public static HttpURLConnection sendPostRequest(String service, String method)
            throws MalformedURLException, IOException{

        HttpURLConnection connection = null;

        try {

            URL url = new URL(URL_CONTEXT + service);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.connect();

        } catch (Exception e){
        	System.out.println("HttpService: " + e.getMessage());
        }/*finally {
        }

            connection.disconnect();
        }*/

        return connection;
    }

    public static Response sendJsonPostRequest(JSONObject jsonObject, String service) {
    	
    	 HttpURLConnection connection = null;
    	 Response response=null;
    	    	
    	try {
    		 URL url = new URL(URL_CONTEXT + service);
    		 
	    	connection = (HttpURLConnection) url.openConnection();
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        connection.setRequestProperty("Content-Type", "application/json");

	        connection.connect();
	        
			connection.setRequestMethod("POST");
			
			int httpCode = connection.getResponseCode();
			String content = getHttpContent(connection);

			connection.disconnect();

			response = new Response(httpCode, content);

		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        return response;
    }

    public static String getHttpContent(HttpURLConnection connection) {

        StringBuilder builder = new StringBuilder();

        try {

            InputStream content = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    content, "iso-8859-1"), 8);

            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            content.close();

        } catch (IOException e) {

            Log.e("NotificationApp", "IOException: " + e);
        }

        return builder.toString();
    }
}