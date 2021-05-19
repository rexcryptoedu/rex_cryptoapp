package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.activity.InitialActivity;
import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin, buttonBack;

    private EditText editEmail, editPassword;

    private String email, password;

    private User user;

    private FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonBack = findViewById(R.id.buttonBack);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = editEmail.getText().toString();
                password = editPassword.getText().toString();

                if ( !email.isEmpty() ){
                    if ( !password.isEmpty() ){

                        user = new User();
                        user.setEmail( email );
                        user.setPassword( password );
                        validateLogin();

                        //impede clique duplo no botão
                        buttonLogin.setEnabled(false);
                        buttonLogin.setTextColor(Color.WHITE);

                    }else {
                        Toast.makeText(LoginActivity.this,
                                "Preencha o senha!",
                                Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this,
                            "Preencha a email!",
                            Toast.LENGTH_LONG).show();
                }



            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }

    public void validateLogin(){

        authentication = FirebaseConfiguration.getFirebaseAuthentication();
        authentication.signInWithEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if ( task.isSuccessful() ){

                    openMainScreen();

                }else {

                    String exception = "";
                    try {
                        throw task.getException();
                    }catch ( FirebaseAuthInvalidUserException e) {
                        exception = "Usuário não está cadastrado";
                    }catch ( FirebaseAuthInvalidCredentialsException e) {
                        exception = "E-mail e senha não correspondem a um usuário cadastrado";
                    }catch ( Exception e) {
                        exception = "Erro ao logar usuário:" + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(LoginActivity.this,
                            exception,
                            Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    public void openMainScreen(){

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

}