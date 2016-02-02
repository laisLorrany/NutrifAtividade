package br.edu.ifpb.nutrif.asynctask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import br.edu.ifpb.nutrif.entidades.Anamnese;
import br.edu.ifpb.nutrif.util.HttpService;
import br.edu.ifpb.nutrif.util.Response;

import com.google.gson.Gson;

public class CalButtonAsyncTask extends AsyncTask<JSONObject, Void, Response>{

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
	protected Response doInBackground(JSONObject... params) {

		HttpURLConnection connection = null;
		Response response;
		int statusCodeHttp = 0;
		String contentValue = null;
		
    	try {
			response = HttpService.sendJSONPostResquest("calcularVCT", params[0]);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}


        response = new Response(statusCodeHttp, contentValue);
        
		Log.i("LoginAsyncTask: ", "doInBackGround");
		
		return response;
	}
	
	@Override
	protected void onPostExecute(Response response){
		Log.i("LoginAsyncTask: ", "onPostExecute");
		Gson gson = new Gson();
				
		try {
            JSONObject jsonResponse = new JSONObject(response.getContentValue());
            String jsonAnamnese = jsonResponse.getString("anamnese");
            
            double vct = jsonResponse.getDouble("valor");
            Anamnese anamnese = gson.fromJson(jsonAnamnese, Anamnese.class);
            
            String titulo = "Valor Calórico Total (VCT)";
            String mensagem = "O VCT é: " + vct +". Anamnese: " + anamnese.toString();
            
        } catch (JSONException e) {
            Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());
        }
	}

}