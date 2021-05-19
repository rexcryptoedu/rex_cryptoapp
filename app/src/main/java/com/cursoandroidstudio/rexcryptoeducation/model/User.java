package com.cursoandroidstudio.rexcryptoeducation.model;

import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

/**
 * Created by filip
 */
public class User {

    private String userId;
    private String userName;
    private String email;
    private String password;

    public User() {
    }

    public void save(){
        DatabaseReference firebase = FirebaseConfiguration.getFirebaseDatabase();
        firebase.child("user")
                .child( this.userId )
                .setValue( this );
    }

    @Exclude
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
