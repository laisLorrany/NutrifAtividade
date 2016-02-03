package br.edu.ifpb.nutrif.asynctask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import br.edu.ifpb.nutrif.R;
import br.edu.ifpb.nutrif.R.id;
import br.edu.ifpb.nutrif.R.layout;
import br.edu.ifpb.nutrif.R.menu;
import br.edu.ifpb.nutrif.dialog.DialogBox;
import br.edu.ifpb.nutrif.entidades.Anamnese;
import br.edu.ifpb.nutrif.util.HttpService;
import br.edu.ifpb.nutrif.util.Response;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class PerfilButtonAsyncTask extends AsyncTask<JSONObject, Void, Response> {

	
Context context;
	
	public PerfilButtonAsyncTask(Context context2) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	protected void onPreExecute(){
		Log.i("PerfilButtonAsyncTask: ", "onPreExecute");
		
	}

	@Override
	protected Response doInBackground(JSONObject... params) {

		HttpURLConnection connection = null;
		Response response;
		int statusCodeHttp = 0;
		String contentValue = null;
		
    	try {
			response = HttpService.sendJSONPostResquest("calcularPerfilAntropometrico", params[0]);
			
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
            
            String diagnostico = jsonResponse.getString("diagnostico");
            
            String titulo = "Perfil Antropométrico";
            DialogBox dialog = new DialogBox(titulo, diagnostico, context);
            dialog.dialogExecute();
            
        } catch (JSONException e) {
            Log.e("LoginAsyncTask", "JSONException: " + e.getMessage());
        }
	}

}
