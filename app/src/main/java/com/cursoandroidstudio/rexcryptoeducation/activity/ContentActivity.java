package com.cursoandroidstudio.rexcryptoeducation.activity;

import android.content.Intent;
import android.os.Bundle;

import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.fragment.CourseFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.fragment.Question1Fragment;
import com.cursoandroidstudio.rexcryptoeducation.fragment.Question2Fragment;
import com.google.firebase.auth.FirebaseAuth;

public class ContentActivity extends AppCompatActivity {

    CourseFragment courseFragment;

    String part;

    private FirebaseAuth authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        part = dados.getString("parte_do_curso");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        courseFragment = new CourseFragment();

        Bundle bundle = new Bundle();
        bundle.putString("parte_do_curso", part);
        courseFragment.setArguments(bundle);

        //Configurar objeto para o Fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContent, courseFragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        String title = String.valueOf(getSupportActionBar().getTitle());
        switch (item.getItemId()) {
            case R.id.action_log_out:

                authentication = FirebaseConfiguration.getFirebaseAuthentication();
                authentication.signOut();
                Log.i("Teste","Entrou");
                finish();
                return true;

            case android.R.id.home:
                if( title.contains("Parte") ) {

                    intent = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity( intent );
                    finish();

                }if( title.equals("Questão 01") ) {

                    intent = new Intent(getApplicationContext(), MainActivity.class);

                    startActivity(intent);
                    finish();

                }else if( title.equals("Questão 02") ) {

                    Question1Fragment question1Fragment = new Question1Fragment();

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameContent, question1Fragment );

                    Bundle bundle = new Bundle();
                    bundle.putString("parte_do_curso", part);
                    question1Fragment.setArguments(bundle);

                    transaction.commit();

                }
                else if ( title.equals("Questão 03") ) {

                    Question2Fragment question2Fragment = new Question2Fragment();

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameContent, question2Fragment );

                    Bundle bundle = new Bundle();
                    bundle.putString("parte_do_curso", part);
                    question2Fragment.setArguments(bundle);

                    transaction.commit();

                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBackPressed() { }

}