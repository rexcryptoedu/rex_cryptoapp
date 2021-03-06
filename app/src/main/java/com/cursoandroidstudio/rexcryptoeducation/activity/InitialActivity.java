package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.google.firebase.auth.FirebaseAuth;

public class InitialActivity extends AppCompatActivity {

    private Button buttonPageLogin, buttonPageRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        buttonPageLogin = findViewById(R.id.buttonPageLogin);
        buttonPageRegister = findViewById(R.id.buttonPageRegister);

        buttonPageLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                startActivity( intent );

            }
        });

        buttonPageRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = "";
                String password = "";

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                //Passar dados para próxima tela
                intent.putExtra("email", email);
                intent.putExtra("senha", password);

                startActivity( intent );

            }
        });

    }
}