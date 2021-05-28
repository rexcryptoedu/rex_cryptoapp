package com.cursoandroidstudio.rexcryptoeducation.model;

import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

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

    public void update(){
        DatabaseReference firebase = FirebaseConfiguration.getFirebaseDatabase();
        DatabaseReference user = firebase
                .child("user")
                .child( getUserId() );

        Map<String, Object> userValues = convertToMap();
        user.updateChildren( userValues );

    }

    public Map<String, Object> convertToMap(){

        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("email", getEmail());
        userMap.put("userName", getUserName());
        userMap.put("userId", getUserId());
        userMap.put("password", getPassword());

        return userMap;

    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
