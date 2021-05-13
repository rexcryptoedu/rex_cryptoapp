package com.cursoandroidstudio.rexcryptoeducation.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cursoandroidstudio.rexcryptoeducation.Question1;
import com.cursoandroidstudio.rexcryptoeducation.Question2;
import com.cursoandroidstudio.rexcryptoeducation.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question2Fragment extends Fragment {

    private TextView textQuestion2;
    private Button buttonQuestion3;

    private String question2Content;

    Question2 question2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Question2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question2Fragment newInstance(String param1, String param2) {
        Question2Fragment fragment = new Question2Fragment();
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
        View v = inflater.inflate(R.layout.fragment_question2, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Questão 02");

        textQuestion2 = v.findViewById(R.id.textQuestion2);
        buttonQuestion3 = v.findViewById(R.id.buttonQuestion3);

        Bundle dados = getArguments();
        String part = dados.getString("parte_do_curso");

        question2 = new Question2();

        question2Content =  question2.question2Content(part);

        textQuestion2.setText(question2Content);

        return v;
    }
}