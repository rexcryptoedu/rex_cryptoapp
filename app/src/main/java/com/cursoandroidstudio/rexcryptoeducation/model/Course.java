package com.cursoandroidstudio.rexcryptoeducation.model;

public class Course {

    private int course_image;
    private String part;
    private String theme;

    public Course(int course_image, String part, String theme) {
        this.course_image = course_image;
        this.part = part;
        this.theme = theme;
    }

    public int getCourse_image() {
        return course_image;
    }

    public void setCourse_image(int course_image) {
        this.course_image = course_image;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
