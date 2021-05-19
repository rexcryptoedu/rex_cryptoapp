package com.cursoandroidstudio.rexcryptoeducation.ui.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.config.FirebaseConfiguration;
import com.cursoandroidstudio.rexcryptoeducation.helper.Base64Custom;
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
    private CircleImageView circleImageUser;

    private DatabaseReference firebaseReference = FirebaseConfiguration.getFirebaseDatabase();
    private FirebaseAuth authentication = FirebaseConfiguration.getFirebaseAuthentication();

    private String userName, email;

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

        editUserNameAlter = v.findViewById(R.id.editUserNameAlter);
        editEmailAlter = v.findViewById(R.id.editEmailAlter);
        editPasswordAlter = v.findViewById(R.id.editPasswordAlter);
        circleImageUser = v.findViewById(R.id.circleImageUser);

        recoverData();

        circleImageUser.setImageResource(R.drawable.user);
        editPasswordAlter.setHint("senha123");

        return v;
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

                editUserNameAlter.setHint(userName);
                editEmailAlter.setHint(email);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}