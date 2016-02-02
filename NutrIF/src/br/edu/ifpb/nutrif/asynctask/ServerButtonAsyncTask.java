package br.edu.ifpb.nutrif.asynctask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import br.edu.ifpb.nutrif.util.HttpService;
import br.edu.ifpb.nutrif.util.Response;

public class ServerButtonAsyncTask extends AsyncTask<String, Void, Response>{

	Context context;
	
	public ServerButtonAsyncTask(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	protected void onPreExecute(){
		Log.i("LoginAsyncTask: ", "onPreExecute");
		
	}

	@Override
	protected Response doInBackground(String... params) {

		HttpURLConnection connection = null;
		Response response;
		int statusCodeHttp = 0;
		String contentValue = null;
		
		try {
			connection = HttpService.sendGetRequest("statusServer");
	        contentValue = HttpService.getHttpContent(connection);
	        statusCodeHttp = connection.getResponseCode();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        response = new Response(statusCodeHttp, contentValue);
        
		Log.i("LoginAsyncTask: ", "doInBackGround");
		
		return response;
	}
	
	@Override
	protected void onPostExecute(Response response){
		Log.i("LoginAsyncTask: ", "onPostExecute");
				
		try {
            JSONObject json = new JSONObject(response.getContentValue());
            String nome = json.getString("online");
            Toast.makeText(context, nome, Toast.LENGTH_LONG).show();           
            
        } catch (JSONException e) {
            Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());
        }
	}

}
