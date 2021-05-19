package com.cursoandroidstudio.rexcryptoeducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.helper.Base64Custom;
import com.cursoandroidstudio.rexcryptoeducation.model.User;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private ImageView imageUser;
    private TextView textUserName, textEmail;

    private DatabaseReference firebaseReference = FirebaseConfiguration.getFirebaseDatabase();
    private FirebaseAuth authentication = FirebaseConfiguration.getFirebaseAuthentication();

    private String userName, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_menu, R.id.nav_profile, R.id.nav_about
        )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Obtém a referência da view de cabeçalho
        View headerView = navigationView.getHeaderView(0);

        // Obtém a referência da imagem, do nome e do e-mail do usuário e altera seu nome
        imageUser = headerView.findViewById(R.id.imageUser);
        textUserName = headerView.findViewById(R.id.textUserName);
        textEmail = headerView.findViewById(R.id.textEmail);

        recoverData();

        /*Verifica usuario logado*/
        if( authentication.getCurrentUser() != null ){
            Log.i("CurrentUser", "Usuario logado!");
        }else {
            Log.i("CurrentUser", "Usuario não logado!");
        }

        imageUser.setImageResource(R.drawable.profile_picture);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_log_out:

                authentication = FirebaseConfiguration.getFirebaseAuthentication();
                authentication.signOut();
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void recoverData(){

        String userEmail = authentication.getCurrentUser().getEmail();
        String userId = Base64Custom.base64Code( userEmail );
        DatabaseReference userReference = firebaseReference.child("user").child( userId );

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User user = snapshot.getValue( User.class );

                userName = user.getUserName();
                email = user.getEmail();

                textUserName.setText(userName);
                textEmail.setText(email);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}