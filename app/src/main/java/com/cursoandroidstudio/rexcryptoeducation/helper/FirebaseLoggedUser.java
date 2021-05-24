package com.cursoandroidstudio.rexcryptoeducation.helper;

import android.util.Log;

import androidx.annotation.NonNull;

import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import org.jetbrains.annotations.NotNull;

/**
 * Created by filip
 */
public class  FirebaseLoggedUser{

    public static FirebaseUser getLoggedUser(){

        FirebaseAuth user = FirebaseConfiguration.getFirebaseAuthentication();
        return user.getCurrentUser();

    }

    public static void updateUserName(String name){

        try {

            //Usuário logado no App
            FirebaseUser LoggedUser = getLoggedUser();

            //Configurar objeto para alteração do perfil
            UserProfileChangeRequest profile = new UserProfileChangeRequest
                    .Builder()
                    .setDisplayName( name )
                    .build();

            LoggedUser.updateProfile( profile ).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if( !task.isSuccessful() ){
                        Log.d("Perfil","Erro ao atualizar nome de prefil");
                    }
                }
            });


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static User getLoggedUserData(){

        FirebaseUser firebaseUser = getLoggedUser();

        User user = new User();
        user.setUserId( firebaseUser.getUid() );
        user.setUserName( firebaseUser.getDisplayName() );
        user.setEmail( firebaseUser.getEmail() );

        return user;
    }

}
