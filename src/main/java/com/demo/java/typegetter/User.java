package com.demo.java.typegetter;

import java.util.List;

/**
 * @Author: zjhan
 * @Date: 2021/6/21 14:40
 * @Description:
 **/
public class User {
    List<Grade> gradeList;

    String userName;

    int age;

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "gradeList=" + gradeList +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
