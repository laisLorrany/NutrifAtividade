package br.edu.ifpb.nutrif.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import br.edu.ifpb.nutrif.R;
import br.edu.ifpb.nutrif.asynctask.ServerButtonAsyncTask;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		Button statusButton = (Button)findViewById(R.id.serverStatus);
		statusButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
	        public void onClick(View v) {
	            Log.i("MainActivity", "Clique no botão da AsyncTask");
	
	            ServerButtonAsyncTask serverButtonAsyncTask = 
	            		new ServerButtonAsyncTask(v.getContext());
	
	            serverButtonAsyncTask.execute();
	            
	        }
		});
		
		Button imcActivity = (Button) findViewById(R.id.ImcButton);
		imcActivity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,ImcActivity.class);
		        startActivity(intent);
			}
		});
	}
	
	
	
}
