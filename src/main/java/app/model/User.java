package main.java.app.model;

public class User {
    private final int id;
    private final String firstName;
//    private final Optional<String> middleName;
    private final String lastName;
    private final int age;

    User(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
//        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(int id) {
        this.id = id;
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }




    // constructor, getters
}

