package com.cursoandroidstudio.rexcryptoeducation.ui.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.adapter.Course_PartAdapter;
import com.cursoandroidstudio.rexcryptoeducation.model.Course_Part;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    private RecyclerView recyclerCourses;
    private List<Course_Part> courses = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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

        View v =  inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerCourses = v.findViewById(R.id.recyclerCourses);

        //Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(v.getContext());

        recyclerCourses.setLayoutManager( layoutManager );

        //define adapter
        prepareCourse();

        Course_PartAdapter adapter = new Course_PartAdapter( courses );
        recyclerCourses.setAdapter( adapter );

        return v;

    }

    public  void prepareCourse() {

        Course_Part c;

        c = new Course_Part(R.drawable.part1_image, "Parte I", "História e criação do Bitcoin");
        this.courses.add(c);

        c = new Course_Part(R.drawable.part2_image, "Parte II", "O Blockchain");
        this.courses.add(c);

        c = new Course_Part(R.drawable.part3_image, "Parte III", "Segurança do Bitcoin e como armazená-los");
        this.courses.add(c);

    }

}