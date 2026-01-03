package app.service;

import app.model.User;

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
        return users.stream()
                .anyMatch(user -> user.getAge() < age);
    }

    public Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
