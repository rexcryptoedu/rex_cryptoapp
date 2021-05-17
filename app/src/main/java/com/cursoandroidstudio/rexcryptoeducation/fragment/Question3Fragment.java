package com.cursoandroidstudio.rexcryptoeducation.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cursoandroidstudio.rexcryptoeducation.Question2;
import com.cursoandroidstudio.rexcryptoeducation.Question3;
import com.cursoandroidstudio.rexcryptoeducation.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question3Fragment extends Fragment {

    private TextView textQuestion3;
    private Button buttonFeedback;
    private EditText editAnswerQuestion3;

    private String question3Content,answerQuestion3;

    Question3 question3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Question3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question3Fragment newInstance(String param1, String param2) {
        Question3Fragment fragment = new Question3Fragment();
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
        View v = inflater.inflate(R.layout.fragment_question3, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Questão 03");

        textQuestion3 = v.findViewById(R.id.textQuestion3);
        buttonFeedback = v.findViewById(R.id.buttonFeedback);
        editAnswerQuestion3 = v.findViewById(R.id.editAnswerQuestion3);

        Bundle dados = getArguments();
        String part = dados.getString("parte_do_curso");
        String answerQuestion1 = dados.getString("resposta_questao_1");
        String[] answerQuestion2 = dados.getStringArray("resposta_questao_2");

        question3 = new Question3();

        question3Content =  question3.question3Content(part);

        textQuestion3.setText(question3Content);

        answerQuestion3 = editAnswerQuestion3.getText().toString();

        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FeedbackFragment feedbackFragment = new FeedbackFragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frameContent, feedbackFragment );

                Bundle bundle = new Bundle();
                bundle.putString("parte_do_curso", part);
                bundle.putString("resposta_questao_1", answerQuestion1);
                bundle.putStringArray("resposta_questao_2", answerQuestion2);
                bundle.putString("resposta_questao_3", answerQuestion3);
                feedbackFragment.setArguments(bundle);

                transaction.commit();

            }
        });

        return v;
    }
}