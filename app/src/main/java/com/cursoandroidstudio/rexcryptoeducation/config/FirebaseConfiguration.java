package com.cursoandroidstudio.rexcryptoeducation.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConfiguration {

    private static FirebaseAuth authentication;
    private static DatabaseReference firebase;

    //retorna a instancia do FirebaseDatabase
    public static DatabaseReference getFirebaseDatabase(){
        if( firebase == null ){
            firebase = FirebaseDatabase.getInstance().getReference();
        }
        return firebase;
    }

    //retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAuthentication(){
        if( authentication == null ){
            authentication = FirebaseAuth.getInstance();
        }
        return authentication;
    }

}
