package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button buttonBackInitial, buttonPageRegister2;
    private EditText editEmailRegister, editPasswordRegister, editConfirmPassword;
    private CheckBox checkPasswordRegister;

    private String email, password, confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        email = dados.getString("email");
        password = dados.getString("senha");

        buttonPageRegister2 = findViewById(R.id.buttonPageRegister2);
        buttonBackInitial = findViewById(R.id.buttonBackInitial);

        editEmailRegister = findViewById(R.id.editEmailRegister);
        editPasswordRegister = findViewById(R.id.editPasswordRegister);
        editConfirmPassword = findViewById(R.id.editConfirm_Password);

        checkPasswordRegister = findViewById(R.id.checkPasswordRegister);

        if ( !email.equals("") && !password.equals("") ) {
            editEmailRegister.setText(email);
            editPasswordRegister.setText(password);
            editConfirmPassword.setText(password);
        }

        checkPasswordRegister.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if ( isChecked ) {
                    editPasswordRegister.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    editConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editPasswordRegister.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        buttonPageRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = editEmailRegister.getText().toString().trim();
                password = editPasswordRegister.getText().toString();
                confirm_password = editConfirmPassword.getText().toString();

                if ( !email.isEmpty() ){
                    if ( !password.isEmpty() ){
                        if ( !confirm_password.isEmpty() ){

                            Intent intent = new Intent(getApplicationContext(), Register2Activity.class);

                            //Passar dados para próxima tela
                            intent.putExtra("email", email);
                            intent.putExtra("senha", password);

                            startActivity( intent );
                            finish();

                        }else {
                            Toast.makeText(RegisterActivity.this,
                                    "Preencha o confirme a senha!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this,
                                "Preencha o senha!",
                                Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(RegisterActivity.this,
                            "Preencha a email!",
                            Toast.LENGTH_SHORT).show();
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