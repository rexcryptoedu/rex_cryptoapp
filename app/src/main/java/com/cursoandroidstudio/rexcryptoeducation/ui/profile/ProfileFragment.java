package com.cursoandroidstudio.rexcryptoeducation.ui.profile;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.activity.MainActivity;
import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.helper.Base64Custom;
import com.cursoandroidstudio.rexcryptoeducation.helper.FirebaseLoggedUser;
import com.cursoandroidstudio.rexcryptoeducation.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private EditText editUserNameAlter, editEmailAlter, editPasswordAlter;
    private CheckBox checkPasswordAlter;
    private Button buttonSave;

    private CircleImageView circleImageUser;

    private DatabaseReference firebaseReference = FirebaseConfiguration.getFirebaseDatabase();
    private FirebaseAuth authentication = FirebaseConfiguration.getFirebaseAuthentication();

    private User loggedUser;

    private String userName, email, password, updatedUserName, updatedEmail,updatedPassword;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        //Configurações iniciais
        loggedUser = FirebaseLoggedUser.getLoggedUserData();


        editUserNameAlter = v.findViewById(R.id.editUserNameAlter);
        editEmailAlter = v.findViewById(R.id.editEmailAlter);
        editPasswordAlter = v.findViewById(R.id.editPasswordAlter);
        checkPasswordAlter = v.findViewById(R.id.checkPasswordAlter);
        buttonSave = v.findViewById(R.id.buttonSave);

        circleImageUser = v.findViewById(R.id.circleImageUser);

        recoverData();

        circleImageUser.setImageResource(R.drawable.user_background);

        editEmailAlter.setFocusable(false);
        editPasswordAlter.setFocusable(false);

        checkPasswordAlter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if ( isChecked ) {
                    editPasswordAlter.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editPasswordAlter.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updatedUserName = editUserNameAlter.getText().toString();
                updatedEmail = editEmailAlter.getText().toString();
                updatedPassword = editPasswordAlter.getText().toString();

                if ( !updatedUserName.isEmpty() ){

                    //Atualizar perfil
                    FirebaseLoggedUser.updateUserName( updatedUserName );

                    //Atualizar perfil no banco de dados
                    loggedUser.setUserName( updatedUserName );
                    loggedUser.update();

                    Toast.makeText(getActivity(),
                            "Dados alterados com sucesso!",
                            Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getActivity(),
                            "Preencha o nome do usuário!",
                            Toast.LENGTH_LONG).show();
                }



            }
        });

        return v;
    }

    public void recoverData(){

        /*
        String userEmail = authentication.getCurrentUser().getEmail();
        String userId = Base64Custom.base64Code( userEmail );
         */
        String userId = authentication.getCurrentUser().getUid();
        DatabaseReference userReference = firebaseReference.child("user").child( userId );

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User user = snapshot.getValue( User.class );

                userName = user.getUserName();
                email = user.getEmail();
                password = user.getPassword();

                editUserNameAlter.setText(userName);
                editEmailAlter.setText(email);
                editPasswordAlter.setText(password);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

         /*
        FirebaseUser userProfile = FirebaseLoggedUser.getLoggedUser();
        editUserNameAlter.setText( userProfile.getDisplayName() );
        editEmailAlter.setText( userProfile.getEmail() );
        */

    }



}