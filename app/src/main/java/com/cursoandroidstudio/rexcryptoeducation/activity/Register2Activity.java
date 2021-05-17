package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cursoandroidstudio.rexcryptoeducation.R;

public class Register2Activity extends AppCompatActivity {

    private Button buttonRegister, buttonBackRegister;

    private EditText editUserName;

    private String userName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        email = dados.getString("email");
        password = dados.getString("senha");

        buttonRegister = findViewById(R.id.buttonRegister);
        buttonBackRegister = findViewById(R.id.buttonBackRegister);

        editUserName = findViewById(R.id.editEmail);

        userName = editUserName.getText().toString();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);

                startActivity( intent );
                finish();

            }
        });


        buttonBackRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                startActivity( intent );
                finish();

            }
        });

    }
}