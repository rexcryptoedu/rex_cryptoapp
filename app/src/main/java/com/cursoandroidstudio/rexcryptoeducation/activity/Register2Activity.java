package com.cursoandroidstudio.rexcryptoeducation.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.helper.Base64Custom;
import com.cursoandroidstudio.rexcryptoeducation.helper.FirebaseLoggedUser;
import com.cursoandroidstudio.rexcryptoeducation.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import org.jetbrains.annotations.NotNull;

public class Register2Activity extends AppCompatActivity {

    private Button buttonRegister, buttonBackRegister;
    private EditText editUserName;
    private ProgressBar progressBarRegister;

    private String userName, email, password;

    private FirebaseAuth authentication;

    private User user;

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

        editUserName = findViewById(R.id.editUserName);

        progressBarRegister = findViewById(R.id.progressBarRegister);

        progressBarRegister.setVisibility( View.GONE );

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = editUserName.getText().toString();

                //Validar se os campos foram preenchidos
                if ( !userName.isEmpty() ){

                    progressBarRegister.setVisibility( View.VISIBLE );

                    user = new User();
                    user.setUserName( userName );
                    user.setEmail( email );
                    user.setPassword( password );
                    registerUser();

                }else {
                    Toast.makeText(Register2Activity.this,
                            "Preencha o nome!",
                            Toast.LENGTH_LONG).show();
                }

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

    public void registerUser(){

        authentication = FirebaseConfiguration.getFirebaseAuthentication();
        authentication.createUserWithEmailAndPassword(
              user.getEmail(),user.getPassword()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful() ){

                    //Salvar dados no firebase
                    String userId = task.getResult().getUser().getUid();
                    user.setUserId( userId );
                    user.save();
                    finish();

                    //Salvar dados no profile do Firebase
                    FirebaseLoggedUser.updateUserName( user.getUserName() );

                    /*
                    String userId = Base64Custom.base64Code( user.getEmail() );
                    user.setUserId( userId );
                    user.save();
                    finish();
                    */
                    /*
                    Toast.makeText(Register2Activity.this,
                            "Sucesso ao cadastrar usuário!",
                            Toast.LENGTH_LONG).show();
                     */

                }else {

                    String exception = "";
                    try {
                        throw task.getException();
                    }catch ( FirebaseAuthWeakPasswordException e){
                        exception = "Digite uma senha mais forte!";
                    }catch ( FirebaseAuthInvalidCredentialsException e) {
                        exception = "Por favor, digite um e-mail válido";
                    }catch ( FirebaseAuthUserCollisionException e) {
                        exception = "Esta conta já foi cadastrada";
                    }catch ( Exception e) {
                        exception = "Erro ao cadastrar usuário:" + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(Register2Activity.this,
                            exception,
                            Toast.LENGTH_LONG).show();

                }
            }
        });

    }

}