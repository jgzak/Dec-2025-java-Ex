package app.util;

import app.model.User;

import java.util.List;

public class UserPrinter {
    public static void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
