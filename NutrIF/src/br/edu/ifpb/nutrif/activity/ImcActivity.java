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

	            String [] valores = {peso, altura};
	     	            
	            ImcButtonAsyncTask imcAsyncTask = new ImcButtonAsyncTask(v.getContext());
	            
	            imcAsyncTask.execute(valores);
	            
	        }
	    });
		

	}
	}