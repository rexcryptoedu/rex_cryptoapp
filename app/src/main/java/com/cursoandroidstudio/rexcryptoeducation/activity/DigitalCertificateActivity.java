package com.cursoandroidstudio.rexcryptoeducation.activity;

import android.content.Intent;
import android.os.Bundle;

import com.cursoandroidstudio.rexcryptoeducation.fragment.CourseFragment;
import com.cursoandroidstudio.rexcryptoeducation.fragment.DigitalRegisterFragment;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.cursoandroidstudio.rexcryptoeducation.R;

public class DigitalCertificateActivity extends AppCompatActivity {

    DigitalRegisterFragment digitalRegisterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_certificate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        digitalRegisterFragment = new DigitalRegisterFragment();

        //Configurar objeto para o Fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameDigitalCertificate, digitalRegisterFragment);
        transaction.commit();

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}