package main.java.app.service;

import main.java.app.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {


    public Optional<User> findById(List<User> users, int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public List<User> findAdults(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 18)
                .toList();
    }

    public boolean anyUserUnderAge(List<User> users, int age) {
        int size = users.stream()
                .filter(user -> user.getAge() < age)
                .toList()
                .size();
        return size > 0;
    }

    public Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
