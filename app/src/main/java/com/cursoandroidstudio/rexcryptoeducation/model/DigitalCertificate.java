package com.cursoandroidstudio.rexcryptoeducation.model;

import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

/**
 * Created by filip
 */
public class DigitalCertificate {

    private String userId;
    private String fullName;
    private String secondaryEmail;
    private String phone;

    public DigitalCertificate() {
    }

    public void save(){
        DatabaseReference firebase = FirebaseConfiguration.getFirebaseDatabase();
        firebase.child("user")
                .child( this.userId )
                .child("digital")
                .setValue( this );
    }

    @Exclude
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
