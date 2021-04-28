package com.cursoandroidstudio.rexcryptoeducation.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.activity.ContentActivity;
import com.cursoandroidstudio.rexcryptoeducation.activity.InitialActivity;
import com.cursoandroidstudio.rexcryptoeducation.activity.LoginActivity;
import com.cursoandroidstudio.rexcryptoeducation.activity.MainActivity;
import com.cursoandroidstudio.rexcryptoeducation.activity.Register2Activity;
import com.cursoandroidstudio.rexcryptoeducation.activity.RegisterActivity;
import com.cursoandroidstudio.rexcryptoeducation.fragment.CourseFragment;
import com.cursoandroidstudio.rexcryptoeducation.model.Course;

import java.util.List;
import java.util.Random;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {

    private List<Course> courses;

    public CourseAdapter(List<Course> listCourses) {
        this.courses = listCourses;
    }

    @Override
    public CourseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View courseList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_details, parent, false);

        return new MyViewHolder(courseList);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int position) {

        Course course = courses.get( position );
        holder.imageCourse.setImageResource( course.getCourse_image() );
        holder.textPart.setText( course.getPart() );
        holder.textTheme.setText( course.getTheme() );

        String part = holder.textPart.getText().toString();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity)v.getContext();

                Intent intent = new Intent(activity.getApplicationContext(), ContentActivity.class);

                //Passar dados para próxima tela
                intent.putExtra("parte", part);

                activity.startActivity( intent );
            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        private ImageView imageCourse;
        private TextView textPart;
        private TextView textTheme;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCourse = itemView.findViewById(R.id.imageCourse);
            textPart = itemView.findViewById(R.id.textPart);
            textTheme = itemView.findViewById(R.id.textTheme);
        }
    }
}
