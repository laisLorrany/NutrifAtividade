package br.edu.ifpb.nutrif.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.edu.ifpb.nutrif.R;
import br.edu.ifpb.nutrif.asynctask.*;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
	            EditText nascimentoEditText = (EditText) findViewById(R.id.nasc);
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
	            

	           String [] valores = {peso, altura, esporte, sexo, nascimento};
	     	            
	            CalButtonAsyncTask calButtonAsynctask = new CalButtonAsyncTask(v.getContext());
	            
	           calButtonAsynctask.execute(valores);
	            
	        }
	    });
		

	}
}