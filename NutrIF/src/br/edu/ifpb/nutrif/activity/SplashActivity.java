package br.edu.ifpb.nutrif.activity;

import br.edu.ifpb.nutrif.R;
import br.edu.ifpb.nutrif.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity implements Runnable {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 5000);
    }

    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}