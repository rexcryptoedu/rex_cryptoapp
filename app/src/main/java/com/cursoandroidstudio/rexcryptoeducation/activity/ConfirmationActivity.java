package com.cursoandroidstudio.rexcryptoeducation.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.fragment.ConfirmationFragment;

public class ConfirmationActivity extends AppCompatActivity {

    ConfirmationFragment confirmationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        confirmationFragment = new ConfirmationFragment();

        //Configurar objeto para o Fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConfirmation, confirmationFragment);
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

    @Override
    public void onBackPressed() { }

}