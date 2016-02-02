package br.edu.ifpb.nutrif.asynctask;

import br.edu.ifpb.nutrif.util.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class CalButtonAsyncTask extends AsyncTask<String, Void, Response>{

	Context context;
	
	public CalButtonAsyncTask(Context context) {
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
		
		JSONObject json = new JSONObject();
        try {
        	json.put("peso", Float.parseFloat(params[0]));
        	json.put("altura", Float.parseFloat(params[1]));
        	json.put("esporte", Float.parseFloat(params[2]));
        	json.put("sexo", Float.parseFloat(params[3]));
        	json.put("nascimento", Float.parseFloat(params[4]));
        	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		response = HttpService.sendJsonPostRequest(json, "calcularIMC");

        response = new Response(statusCodeHttp, contentValue);
        
		Log.i("LoginAsyncTask: ", "doInBackGround");
		
		return response;
	}
	
	@Override
	protected void onPostExecute(Response response){
		Log.i("LoginAsyncTask: ", "onPostExecute");
				
		try {
            JSONObject json = new JSONObject(response.getContentValue());
            double vct = json.getDouble("valor");
            JSONObject anamnese = json.getDouble("anamnese");
            double peso = anamnese.getDouble("peso");
            double altura = anamnese.getDouble("altura");
            double esporte = anamnese.getDouble("esporte");
            JSONObject entrevistado = anamnese.getString("entrevistado");
            String nascimento = entrevistado.getString("nascimento");
            String sexo = entrevistado.getString("sexo");
            Toast.makeText(context, "O valor cal�rico total �: "+vct, Toast.LENGTH_LONG).show();  
            Toast.makeText(context, "O peso �: "+peso, Toast.LENGTH_LONG).show();         
            Toast.makeText(context, "A altura �: "+altura, Toast.LENGTH_LONG).show();
            Toast.makeText(context, "O n�vel de esporte �: "+esporte, Toast.LENGTH_LONG).show();
            Toast.makeText(context, "A data de nascimento �: "+nascimento, Toast.LENGTH_LONG).show();
            Toast.makeText(context, "O sexo �: "+sexo, Toast.LENGTH_LONG).show();
            
        } catch (JSONException e) {
            Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());
        }
	}

}