package com.shourov.mycgpa.ModelClass;

import java.io.Serializable;

public class Model_class implements Serializable {
    String course_name,course_remarks;
    int semester,id;
    float credit,grade;


    public Model_class(String course_name, String course_remarks, int semester, int id, float credit, float grade) {
        this.course_name = course_name;
        this.course_remarks = course_remarks;
        this.semester = semester;
        this.id = id;
        this.credit = credit;
        this.grade = grade;
    }

    public Model_class(String course_name, String course_remarks, int semester, float credit, float grade) {
        this.course_name = course_name;
        this.course_remarks = course_remarks;
        this.semester = semester;

        this.credit = credit;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_remarks() {
        return course_remarks;
    }

    public void setCourse_remarks(String course_remarks) {
        this.course_remarks = course_remarks;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
