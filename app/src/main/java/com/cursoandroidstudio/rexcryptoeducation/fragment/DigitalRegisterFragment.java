package com.cursoandroidstudio.rexcryptoeducation.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.activity.Register2Activity;
import com.cursoandroidstudio.rexcryptoeducation.activity.RegisterActivity;
import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.helper.FirebaseLoggedUser;
import com.cursoandroidstudio.rexcryptoeducation.model.DigitalCertificate;
import com.cursoandroidstudio.rexcryptoeducation.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DigitalRegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DigitalRegisterFragment extends Fragment {

    private EditText editFullName, editDigitalSecondaryEmail, editDigitalPhone;
    private Button buttonRequestDigitalCertificate;

    private ProgressBar progressBarDigital;

    private String fullName, secondaryEmail, phone, certificate;

    private DatabaseReference firebaseReference = FirebaseConfiguration.getFirebaseDatabase();
    private FirebaseAuth authentication = FirebaseConfiguration.getFirebaseAuthentication();

    private DigitalCertificate digitalCertificate;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DigitalRegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DigitalRegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DigitalRegisterFragment newInstance(String param1, String param2) {
        DigitalRegisterFragment fragment = new DigitalRegisterFragment();
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
        View v = inflater.inflate(R.layout.fragment_digital_register, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Certificado Digital");

        editFullName = v.findViewById(R.id.editFullName);
        editDigitalSecondaryEmail = v.findViewById(R.id.editDigitalSecondaryEmail);
        editDigitalPhone = v.findViewById(R.id.editDigitalPhone);

        buttonRequestDigitalCertificate = v.findViewById(R.id.buttonRequestDigitalCertificate);

        progressBarDigital = v.findViewById(R.id.progressBarDigital);

        progressBarDigital.setVisibility( View.GONE );

        buttonRequestDigitalCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fullName = editFullName.getText().toString();
                secondaryEmail = editDigitalSecondaryEmail.getText().toString();
                phone = editDigitalPhone.getText().toString();

                certificate = "DIGITAL";

                if ( !fullName.isEmpty() ){
                    if ( !secondaryEmail.isEmpty() ){
                        if ( !secondaryEmail.isEmpty() ){

                            progressBarDigital.setVisibility( View.GONE );

                            digitalCertificate = new DigitalCertificate();
                            digitalCertificate.setFullName( fullName );
                            digitalCertificate.setSecondaryEmail( secondaryEmail );
                            digitalCertificate.setPhone( phone );
                            registerCertificate();

                            callConfirmation();

                        }else {
                            Toast.makeText(getActivity(),
                                    "Preencha o telefone!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getActivity(),
                                "Preencha o email!",
                                Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getActivity(),
                            "Preencha o nome completo!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        return v;
    }

    public void registerCertificate(){

        authentication = FirebaseConfiguration.getFirebaseAuthentication();

        //Salvar dados no firebase
        String userId = authentication.getCurrentUser().getUid();
        DatabaseReference userReference = firebaseReference.child("user").child( userId );
        digitalCertificate.setUserId( userId );
        digitalCertificate.save();

    }

    public void callConfirmation(){

        ConfirmationFragment confirmationFragment = new ConfirmationFragment();

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameDigitalCertificate, confirmationFragment );

        Bundle bundle = new Bundle();
        bundle.putString("certificado", certificate);
        confirmationFragment.setArguments(bundle);

        transaction.commit();

    }

}