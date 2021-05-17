package com.cursoandroidstudio.rexcryptoeducation.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cursoandroidstudio.rexcryptoeducation.Feedback;
import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.activity.ContentActivity;
import com.cursoandroidstudio.rexcryptoeducation.activity.InitialActivity;
import com.cursoandroidstudio.rexcryptoeducation.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeedbackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeedbackFragment extends Fragment {

    public TextView textTitle,textCorrectFeedback, textIncorrectFeedback,
            textCorrectQuestion1, textCorrectQuestion2, textCorrectQuestion3,
            textIncorrectQuestion1, textIncorrectQuestion2, textIncorrectQuestion3;
    private Button buttonMenu;

    String part, answerQuestion1, answerQuestion3;
    String[] answerQuestion2;

    Feedback feedback;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FeedbackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeedbackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeedbackFragment newInstance(String param1, String param2) {
        FeedbackFragment fragment = new FeedbackFragment();
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
        View v = inflater.inflate(R.layout.fragment_feedback, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Bundle dados = getArguments();
        part = dados.getString("parte_do_curso");
        answerQuestion1 = dados.getString("resposta_questao_1");
        answerQuestion2 = dados.getStringArray("resposta_questao_2");
        answerQuestion3 = dados.getString("resposta_questao_3");

        textTitle               = v.findViewById(R.id.textTitle);

        textCorrectFeedback     = v.findViewById(R.id.textCorrectFeedback);
        textCorrectQuestion1    = v.findViewById(R.id.textCorrectQuestion1);
        textCorrectQuestion2    = v.findViewById(R.id.textCorrectQuestion2);
        textCorrectQuestion3    = v.findViewById(R.id.textCorrectQuestion3);

        textIncorrectFeedback   = v.findViewById(R.id.textIncorrectFeedback);
        textIncorrectQuestion1  = v.findViewById(R.id.textIncorrectQuestion1);
        textIncorrectQuestion2  = v.findViewById(R.id.textIncorrectQuestion2);
        textIncorrectQuestion3  = v.findViewById(R.id.textIncorrectQuestion3);

        buttonMenu  = v.findViewById(R.id.buttonMenu);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Parabéns");

        textTitle.setText("Parabéns!\nVocê foi\nAPROVADO!");
        textCorrectFeedback.setText("Você acertou DUAS questões");
        textIncorrectFeedback.setText("Você errou UMA questão");

        //textCorrectQuestion1.setVisibility(v.VISIBLE);
        checkFeedback();
        textCorrectQuestion2.setVisibility(v.VISIBLE);
        textCorrectQuestion3.setVisibility(v.INVISIBLE);

        textIncorrectQuestion1.setVisibility(v.INVISIBLE);
        textIncorrectQuestion2.setVisibility(v.INVISIBLE);
        textIncorrectQuestion3.setVisibility(v.VISIBLE);

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity)v.getContext();

                Intent intent = new Intent(activity.getApplicationContext(), MainActivity.class);

                activity.startActivity( intent );
                activity.finish();


            }
        });

        return v;
    }

    public void checkFeedback(){

        View v = null;

        feedback = new Feedback();

        if (feedback.question1Feedback(part, answerQuestion1) == true) {
            textCorrectQuestion1.setVisibility(v.VISIBLE);
        } else if (feedback.question1Feedback(part, answerQuestion1) == false) {
            textCorrectQuestion1.setVisibility(v.INVISIBLE);
        }

    }

}