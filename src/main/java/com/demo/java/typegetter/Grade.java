package com.demo.java.typegetter;

/**
 * @Author: zjhan
 * @Date: 2021/6/21 14:41
 * @Description:
 **/
public class Grade {
    String subject;
    double grade;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "subject='" + subject + '\'' +
                ", grade=" + grade +
                '}';
    }
}
