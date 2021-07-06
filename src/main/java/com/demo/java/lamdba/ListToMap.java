package com.demo.java.lamdba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zjhan
 * @Date: 2021/7/6 16:46
 * @Description:
 **/
public class ListToMap {


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        User user1 = new User("xx", 10);
        User user2 = new User("yy", 11);

        users.add(user1);
        users.add(user2);

        Map<String, User> userMap =  users.stream().collect(Collectors.toMap(User::getName, u->u));

        for (String name: userMap.keySet()) {
            System.out.println(name);
            System.out.println(userMap.get(name));
        }
    }
}
