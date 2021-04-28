package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cursoandroidstudio.rexcryptoeducation.R;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonBackInitial, buttonPageRegister2;

    private EditText editEmailRegister, editPasswordRegister, editConfirmPassword;

    private String email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonPageRegister2 = findViewById(R.id.buttonPageRegister2);
        buttonBackInitial = findViewById(R.id.buttonBackInitial);

        editEmailRegister = findViewById(R.id.editEmailRegister);
        editPasswordRegister = findViewById(R.id.editPasswordRegister);
        editConfirmPassword = findViewById(R.id.editConfirm_Password);

        buttonPageRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = editEmailRegister.getText().toString();
                senha = editPasswordRegister.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Register2Activity.class);

                //Passar dados para próxima tela
                intent.putExtra("email", email);
                intent.putExtra("senha", senha);

                startActivity( intent );

            }
        });

        buttonBackInitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);

                startActivity( intent );
                finish();

            }
        });

    }
}