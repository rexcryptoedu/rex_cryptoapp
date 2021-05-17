package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.activity.InitialActivity;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin, buttonBack;

    private EditText editEmail, editPassword;

    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonBack = findViewById(R.id.buttonBack);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        email = editEmail.getText().toString();
        password = editPassword.getText().toString();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity( intent );
                finish();

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);

                startActivity( intent );
                finish();

            }
        });

    }
}