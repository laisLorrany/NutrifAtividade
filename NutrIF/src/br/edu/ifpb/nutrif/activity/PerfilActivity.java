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
import br.edu.ifpb.nutrif.asynctask.PerfilButtonAsyncTask;
import br.edu.ifpb.nutrif.entidades.Entrevistado;

import com.google.gson.Gson;

public class PerfilActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		Button asyncTaskButton = (Button)findViewById(R.id.perfilButton);
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
	            
	            
	            String sexo="";
	            RadioGroup rg = (RadioGroup)findViewById(R.id.rgopcoes);
	            int op = rg.getCheckedRadioButtonId();
	             
	            
	            if(op==R.id.radioButton4){
	            	RadioButton sexoRadio = (RadioButton) findViewById(R.id.radioButton4);
	            	sexo = sexoRadio.getText().toString();
	            }           
	            else
	            if(op==R.id.radioButton5){
	            	RadioButton sexoRadio = (RadioButton) findViewById(R.id.radioButton5);
	            	sexo = sexoRadio.getText().toString();
	            }
	            

	            Entrevistado entrevistado = new Entrevistado(nascimento, sexo);
	            
	            Gson gson = new Gson();
	            String jsonEntrevistado = gson.toJson(entrevistado);
	            
				JSONObject jsonPerfil = new JSONObject();
				
				try {
					jsonPerfil.put("peso", Float.parseFloat(peso));
					jsonPerfil.put("altura", Float.parseFloat(altura));
					jsonPerfil.put("entrevistado", jsonEntrevistado);
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	     	            
	            PerfilButtonAsyncTask perfilButtonAsyncTask = new PerfilButtonAsyncTask(v.getContext());
	            perfilButtonAsyncTask.execute(jsonPerfil);
	            
	        }
	    });
		

	}
}
