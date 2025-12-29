package main.java.app.util;

import main.java.app.model.User;

import java.util.List;

public class UserPrinter {
    static void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
