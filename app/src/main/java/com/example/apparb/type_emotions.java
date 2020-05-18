package com.example.apparb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class type_emotions extends AppCompatActivity {
    ImageView foto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_emotions);
        foto1 = (ImageView)findViewById(R.id.foto1);
        foto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_emotions.this,type_emociones.class);
                startActivity(intent);
            }
        });
    }
}
