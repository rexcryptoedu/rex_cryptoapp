package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonBackInitial, buttonPageRegister2;

    private EditText editEmailRegister, editPasswordRegister, editConfirmPassword;

    private String email, password;

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
                password = editPasswordRegister.getText().toString();

                if ( !email.isEmpty() ){
                    if ( !password.isEmpty() ){

                        Intent intent = new Intent(getApplicationContext(), Register2Activity.class);

                        //Passar dados para próxima tela
                        intent.putExtra("email", email);
                        intent.putExtra("senha", password);

                        startActivity( intent );
                        finish();

                    }else {
                        Toast.makeText(RegisterActivity.this,
                                "Preencha o senha!",
                                Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(RegisterActivity.this,
                            "Preencha a email!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        buttonBackInitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
}