package com.cursoandroidstudio.rexcryptoeducation.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cursoandroidstudio.rexcryptoeducation.Question1;
import com.cursoandroidstudio.rexcryptoeducation.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question1Fragment extends Fragment {

    private TextView textQuestion1;
    private RadioButton radioQuestion1A, radioQuestion1B, radioQuestion1C, radioQuestion1D;
    private RadioGroup radioGroupQuestion1;
    private Button buttonQuestion2;

    private String question1Content, answerQuestion1 = "";
    private String[] questionAlternatives;

    private Question1 question1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Question1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question1Fragment newInstance(String param1, String param2) {
        Question1Fragment fragment = new Question1Fragment();
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
        View v = inflater.inflate(R.layout.fragment_question1, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Questão 01");

        textQuestion1       = v.findViewById(R.id.textQuestion1);
        radioQuestion1A     = v.findViewById(R.id.radioQuestion1A);
        radioQuestion1B     = v.findViewById(R.id.radioQuestion1B);
        radioQuestion1C     = v.findViewById(R.id.radioQuestion1C);
        radioQuestion1D     = v.findViewById(R.id.radioQuestion1D);
        radioGroupQuestion1 = v.findViewById(R.id.radioGroupQuestion1);

        buttonQuestion2     = v.findViewById(R.id.buttonQuestion2);

        Bundle dados = getArguments();
        String part = dados.getString("parte_do_curso");

        question1 = new Question1();

        question1Content =  question1.question1Content(part);
        questionAlternatives =  question1.question1Alternatives(part);

        textQuestion1.setText(question1Content);
        radioQuestion1A.setText(questionAlternatives[0]);
        radioQuestion1B.setText(questionAlternatives[1]);
        radioQuestion1C.setText(questionAlternatives[2]);
        radioQuestion1D.setText(questionAlternatives[3]);

        buttonQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                radioButtonQuestion1();

                Question2Fragment question2Fragment = new Question2Fragment();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frameContent, question2Fragment );

                //Validar se os campos foram preenchidos
                if ( !answerQuestion1.isEmpty() ){

                    Bundle bundle = new Bundle();
                    bundle.putString("parte_do_curso", part);
                    bundle.putString("resposta_questao_1", answerQuestion1);
                    question2Fragment.setArguments(bundle);

                    transaction.commit();

                }else {
                    Toast.makeText(getActivity(),
                            "Escolha uma das alternativas!",
                            Toast.LENGTH_LONG).show();
                }



            }
        });

        return v;
    }

    public void radioButtonQuestion1(){

        radioGroupQuestion1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if( checkedId == R.id.radioQuestion1A ){
                    answerQuestion1 = radioQuestion1A.getText().toString();
                }else if( checkedId == R.id.radioQuestion1B ){
                    answerQuestion1 = radioQuestion1B.getText().toString();
                }else if( checkedId == R.id.radioQuestion1C ){
                    answerQuestion1 = radioQuestion1C.getText().toString();
                }else if( checkedId == R.id.radioQuestion1D ){
                    answerQuestion1 =  radioQuestion1D.getText().toString();
                }

            }
        });

    }

}