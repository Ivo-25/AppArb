package com.example.apparb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import static android.view.View.*;

public class register extends AppCompatActivity implements OnClickListener {
    TextInputEditText etname,etemail,etusername,etpass,etpass2;
    Button Registrar;
    ImageView IvRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etname = (TextInputEditText)findViewById(R.id.txtLayoutNombreR);
        etemail = (TextInputEditText)findViewById(R.id.txtLayoutEmailR);
        etusername = (TextInputEditText)findViewById(R.id.txtLayoutUserR);
        etpass = (TextInputEditText)findViewById(R.id.txtLayoutPassR);
        etpass2 = (TextInputEditText)findViewById(R.id.txtLayoutPass2R);
        IvRefresh = (ImageView)findViewById(R.id.refreshR);
        IvRefresh.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                etname.setText("");
                etemail.setText("");
                etusername.setText("");
                etpass.setText("");
                etpass2.setText("");
            }
        });

        Registrar = (Button)findViewById(R.id.BotonRegister_R);
        Registrar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        final String name = etname.getText().toString();
        final String email = etemail.getText().toString();
        final String username = etusername.getText().toString();
        final String pass = etpass.getText().toString();
        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonReponse = new JSONObject(response);
                    boolean success = jsonReponse.getBoolean("success");
                    if (success){
                        Intent intent = new Intent(register.this,login.class);
                        register.this.startActivity(intent);
                        AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                        builder.setMessage("Registro exitoso").setNegativeButton("Retry",null).create().show();
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                        builder.setMessage("error en el registro").setNegativeButton("Retry",null).create().show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        RegisterRequest registerRequest = new RegisterRequest(name,email,username,pass,respoListener);
        RequestQueue queue = Volley.newRequestQueue(register.this);
        queue.add(registerRequest);


    }
}
