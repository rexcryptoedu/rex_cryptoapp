package com.cursoandroidstudio.rexcryptoeducation.activity;

import android.content.Intent;
import android.os.Bundle;

import com.cursoandroidstudio.rexcryptoeducation.fragment.CourseFragment;
import com.cursoandroidstudio.rexcryptoeducation.fragment.Audio_ConfigurationFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;

import com.cursoandroidstudio.rexcryptoeducation.R;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        String part = dados.getString("parte");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(part);

        CourseFragment courseFragment = new CourseFragment();

        //Configurar objeto para o Fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContent, courseFragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_audio_configuration:

                Audio_ConfigurationFragment audio_configurationFragment = new Audio_ConfigurationFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, audio_configurationFragment)
                        .addToBackStack(null)
                        .commit();

                return true;
            case R.id.action_log_out:

                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);

                startActivity( intent );

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}