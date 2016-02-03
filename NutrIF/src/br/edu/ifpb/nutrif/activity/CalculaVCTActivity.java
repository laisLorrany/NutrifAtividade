package br.edu.ifpb.nutrif.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import br.edu.ifpb.nutrif.R;
import br.edu.ifpb.nutrif.asynctask.CalButtonAsyncTask;
import br.edu.ifpb.nutrif.entidades.Entrevistado;

import com.google.gson.Gson;

public class CalculaVCTActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_valorcal);
		
		Button asyncTaskButton = (Button)findViewById(R.id.calculaVctButton);
		asyncTaskButton.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            Log.i("CalculaVCTActivity", "Clique no botão da AsyncTask");

	            EditText pesoEditText = (EditText) findViewById(R.id.pesoEditText);
	            String peso = pesoEditText.getText().toString();
	            EditText alturaEditText = (EditText) findViewById(R.id.alturaEditText);
	            String altura = alturaEditText.getText().toString();
	            
	            EditText nascimentoEditText = (EditText) findViewById(R.id.nascimento);
	            String nascimento = nascimentoEditText.getText().toString();
	            
	            //recuperando variaveis do radio button de niveis de esporte
	            
	            String esporte="";
	            
	            RadioGroup rg = (RadioGroup)findViewById(R.id.rgopcoes);
	            int op = rg.getCheckedRadioButtonId();
	             
	            if(op==R.id.radioButton1){
	            	RadioButton NivelEsporte = (RadioButton) findViewById(R.id.radioButton1);
	            	esporte = NivelEsporte.getText().toString();
	            }           
	            else
	            if(op==R.id.radioButton2){
	            	RadioButton NivelEsporte = (RadioButton) findViewById(R.id.radioButton1);
	            	esporte = NivelEsporte.getText().toString();
	            }
	            else
	            	if (op==R.id.radioButton3){
	            		RadioButton NivelEsporte = (RadioButton) findViewById(R.id.radioButton1);
	            		esporte = NivelEsporte.getText().toString();}
	            
	            System.out.print(op);
	            
	            //recuperando variaveis do radio button de niveis de sexo
	            
	            String sexo="";
	                         
	            if(op==R.id.radioButton4){
	            	RadioButton sexoRadio = (RadioButton) findViewById(R.id.radioButton4);
	            	sexo = sexoRadio.getText().toString();
	            }           
	            else
	            if(op==R.id.radioButton5){
	            	RadioButton sexoRadio = (RadioButton) findViewById(R.id.radioButton5);
	            	sexo = sexoRadio.getText().toString();
	            }
	            
	            System.out.print(op);

	            Entrevistado entrevistado = new Entrevistado(nascimento, sexo);
	            
	            Gson gson = new Gson();
	            String jsonEntrevistado = gson.toJson(entrevistado);
	            
				JSONObject jsonVct = new JSONObject();
				
				try {
					jsonVct.put("peso", Float.parseFloat(peso));
					jsonVct.put("altura", Float.parseFloat(altura));
					jsonVct.put("nivelEsporte", Integer.parseInt(esporte));
					jsonVct.put("entrevistado", jsonEntrevistado);
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	     	            
	            CalButtonAsyncTask calButtonAsynctask = new CalButtonAsyncTask(v.getContext());
	            calButtonAsynctask.execute(jsonVct);
	            
	        }
	    });
		

	}
}
