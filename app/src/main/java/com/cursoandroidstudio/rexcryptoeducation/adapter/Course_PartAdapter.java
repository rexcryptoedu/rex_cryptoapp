package com.cursoandroidstudio.rexcryptoeducation.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroidstudio.rexcryptoeducation.R;
import com.cursoandroidstudio.rexcryptoeducation.activity.ContentActivity;
import com.cursoandroidstudio.rexcryptoeducation.fragment.CourseFragment;
import com.cursoandroidstudio.rexcryptoeducation.model.Course_Part;

import java.util.List;

public class Course_PartAdapter extends RecyclerView.Adapter<Course_PartAdapter.MyViewHolder> {

    private List<Course_Part> courses;

    public Course_PartAdapter(List<Course_Part> listCourses) {
        this.courses = listCourses;
    }

    @Override
    public Course_PartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View courseList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_details, parent, false);

        return new MyViewHolder(courseList);
    }

    @Override
    public void onBindViewHolder(@NonNull Course_PartAdapter.MyViewHolder holder, int position) {

        Course_Part coursePart = courses.get( position );
        holder.imageCourse.setImageResource( coursePart.getCourse_image() );
        holder.textPart.setText( coursePart.getPart() );
        holder.textTheme.setText( coursePart.getTheme() );

        String part = holder.textPart.getText().toString();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity)v.getContext();

                Intent intent = new Intent(activity.getApplicationContext(), ContentActivity.class);

                //Passar dados para próxima tela
                intent.putExtra("parte_do_curso", part);

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
