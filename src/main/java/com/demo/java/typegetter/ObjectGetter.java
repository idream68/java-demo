package com.demo.java.typegetter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjhan
 * @Date: 2021/6/21 14:40
 * @Description:
 **/
public class ObjectGetter {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List<Grade> gradeList = new ArrayList<>();
        Grade grade = new Grade();
        grade.setGrade(80);
        grade.setSubject("Chinese");
        gradeList.add(grade);
        Grade grade2 = new Grade();
        grade2.setGrade(81);
        grade2.setSubject("Match");
        gradeList.add(grade2);
        User user = new User();
        user.setAge(10);
        user.setUserName("zs");
        user.setGradeList(gradeList);

        List<User> users = new ArrayList<>();
        users.add(user);

        invoke(users);

    }

    private static void invoke(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (o instanceof List) {
            for (Object u: (List) o) {
                Object grades = u.getClass().getMethod("getGradeList").invoke(u);
                System.out.println(grades.getClass());
                if (grades instanceof List) {
                    for (Object grade : (List) grades) {
                        System.out.println(grade);
                    }
                }
                Object name = u.getClass().getMethod("getUserName").invoke(u);
                System.out.println(name.getClass());
                System.out.println(name);
            }
        }
    }
}
