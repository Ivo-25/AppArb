package com.example.apparb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

public class Saludos extends AppCompatActivity {
    TextView tvsaludos;
    Handler handler;
    Runnable runnable;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludos);
        tvsaludos = (TextView)findViewById(R.id.tvSaludos);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvsaludos.setText("Hola "+name+", muchas gracias por logearte!");
        tvsaludos.animate().alpha(2000).setDuration(0);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent despues = new Intent(Saludos.this,type_emotions.class);
                startActivity(despues);
                finish();
            }
        },2000);
    }
}