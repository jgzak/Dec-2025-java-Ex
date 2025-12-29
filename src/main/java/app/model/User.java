package main.java.app.model;

import java.util.Optional;

public class User {
    private final int id;
    private final String firstName;
    private Optional<String> middleName;
    private final String lastName;
    private final int age;

    public User(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(int id, String firstName, String middleName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = Optional.of(middleName);
        this.lastName = lastName;
        this.age = age;
    }

    public User(int id) {
        this(id, "", "", 0);
    }

    @Override
    public String toString() {
        return "User{name='" + firstName + " " +  (middleName != null ? middleName.get() + " " : "")  + lastName + ", age: " + age + "'}";
    }






    // constructor, getters
}

