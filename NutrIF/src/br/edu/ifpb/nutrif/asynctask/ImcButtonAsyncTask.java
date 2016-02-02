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

public class ImcButtonAsyncTask extends AsyncTask<JSONObject, Void, Response>{

	Context context;
	
	public ImcButtonAsyncTask(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	protected void onPreExecute(){
		Log.i("LoginAsyncTask: ", "onPreExecute");
		
	}

	@Override
	protected Response doInBackground(JSONObject... params) {

		Response response = null;
		
        try {
        	response = HttpService.sendJSONPostResquest("calcularIMC", params[0]);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
		Log.i("LoginAsyncTask: ", "doInBackGround");
		
		return response;
	}
	
	@Override
	protected void onPostExecute(Response response){
		Log.i("LoginAsyncTask: ", "onPostExecute");
				
		try {
            JSONObject json = new JSONObject(response.getContentValue());
            double imc = json.getDouble("valor");
            Toast.makeText(context, "O IMC é: "+imc, Toast.LENGTH_LONG).show();           
            
        } catch (JSONException e) {
            Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());
        }
	}

}
