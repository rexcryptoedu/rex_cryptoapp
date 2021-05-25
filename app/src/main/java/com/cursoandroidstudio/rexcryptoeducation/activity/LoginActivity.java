package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    private CheckBox checkPassword;
    private ProgressBar progressBarLogin;

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

        progressBarLogin = findViewById(R.id.progressBarLogin);

        checkPassword = findViewById(R.id.checkPassword);

        progressBarLogin.setVisibility( View.GONE );

        checkPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if ( isChecked ) {
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = editEmail.getText().toString();
                password = editPassword.getText().toString();

                if ( !email.isEmpty() ){
                    if ( !password.isEmpty() ){

                        progressBarLogin.setVisibility( v.VISIBLE );

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

                    progressBarLogin.setVisibility( View.GONE );

                    Toast.makeText(LoginActivity.this,
                            exception,
                            Toast.LENGTH_LONG).show();

                    buttonLogin.setEnabled(true);

                }

            }
        });

    }

    public void openMainScreen(){

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

}