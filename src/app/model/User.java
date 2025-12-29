package app.model;

import java.util.Optional;

public record User(
        int id,
        String firstName,
        String middleName,
        String lastName,
        int age
) {
    public User {
        // basic validation (optional but good practice)
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("firstName/lastName cannot be null");
        }
        if (age < 0) {
            throw new IllegalArgumentException("age cannot be negative");
        }
    }

    public int getId() { return this.id; }
    public int getAge() { return this.age; }

    public Optional<String> middleNameOpt() {
        return Optional.ofNullable(middleName).filter(m -> !m.isBlank());
    }

    public String fullName() {
        return middleNameOpt()
                .map(m -> firstName + " " + m + " " + lastName)
                .orElse(firstName + " " + lastName);
    }

    @Override
    public String toString() {
        return "User{name='" + fullName() + "', age=" + age + ", id=" + id + "}";
    }
}

