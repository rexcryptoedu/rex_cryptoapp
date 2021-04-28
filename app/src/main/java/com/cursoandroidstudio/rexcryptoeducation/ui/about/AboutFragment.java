package com.cursoandroidstudio.rexcryptoeducation.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cursoandroidstudio.rexcryptoeducation.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
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

        String description = "O REX Crypto Education é um aplicativo para pessoas leigas " +
                "que buscam conhecimento sobre criptomoedas. O aplicativo aborda conceitos do " +
                "básico ao avançado, como por exemplo, o surgimento das criptomoedas e como " +
                "operar no mercado de moedas digitais.  ";

        Element versao = new Element();
        versao.setTitle( "Versão 1.0" );

        //View aboutPage = new AboutPage( getActivity() )
        return new AboutPage( getActivity() )
                .setImage(R.drawable.logo)
                .setDescription( description )

                .addGroup("Entre em contato")
                .addEmail("contato.rexcryptoeducation@gmail.com.br", "Envie um e-mail")
                .addWebsite("www.rexcryptoeducation.ga", "Acesse nosso site")

                .addGroup("Redes sociais")
                .addFacebook("rex.investments", "Facebook")
                .addInstagram("rexcryptoedu", "Instagram")
                .addYoutube("REXInvestimentos", "Youtube")
                //.addGitHub("rex_cryptoapp", "GitHub")
                //.addPlayStore("com.facebook.katana", "Download App")

                .addItem( versao )

                .create();

        //return inflater.inflate(R.layout.fragment_contact, container, false);
    }
}