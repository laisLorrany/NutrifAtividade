package br.edu.ifpb.nutrif.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.edu.ifpb.nutrif.R;
import br.edu.ifpb.nutrif.asynctask.ImcButtonAsyncTask;

public class ImcActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imc);
		
		Button asyncTaskButton = (Button)findViewById(R.id.calculaImcButton);
		asyncTaskButton.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            Log.i("MainActivity", "Clique no botão da AsyncTask");

	            EditText pesoEditText = (EditText) findViewById(R.id.pesoEditText);
	            String peso = pesoEditText.getText().toString();
	            EditText alturaEditText = (EditText) findViewById(R.id.alturaEditText);
	            String altura = alturaEditText.getText().toString();

	            JSONObject json = new JSONObject();
	            try {
	            	json.put("peso", Float.parseFloat(peso));
	            	json.put("altura", Float.parseFloat(altura));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     	            
	            ImcButtonAsyncTask imcAsyncTask = new ImcButtonAsyncTask(v.getContext());
	            
	            imcAsyncTask.execute(json.toString());
	            
	        }
	    });
		

	}
	}