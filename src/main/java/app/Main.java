package main.java.app;

import main.java.app.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        ArrayList<String> femaleNames = new ArrayList<>(List.of(
                "Emma", "Olivia", "Sophia", "Amelia", "Isabella",
                "Mia", "Ava", "Charlotte", "Luna", "Harper"
        ));



        ArrayList<String> maleNames = new ArrayList<>(List.of(
                "Liam", "Noah", "Oliver", "James", "Elijah",
                "William", "Henry", "Lucas", "Mason", "Logan"
        ));


        ArrayList<String> lastNames = new ArrayList<>(List.of(
                "Smith", "Johnson", "Williams", "Brown", "Jones",
                "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"
        ));



        boolean isFemale, hasMiddleName;
        Random randomGenerator = new Random();



        List<User> userList = new ArrayList<User>();

        for (int i = 1; i <= 15; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>
            isFemale = randomGenerator.nextBoolean();
            hasMiddleName = randomGenerator.nextBoolean();
            int firstNameIdx = randomGenerator.nextInt(10);
            int middleNameIdx = randomGenerator.nextInt(10);
            int lastNameIdx = randomGenerator.nextInt(10);

            User newUser;
            if(isFemale) {

                if( hasMiddleName ) {
                    newUser = new User(i, femaleNames.get(firstNameIdx), femaleNames.get(middleNameIdx), lastNames.get(lastNameIdx), randomGenerator.nextInt(120));
                } else {
                    newUser = new User(i, femaleNames.get(firstNameIdx), lastNames.get(lastNameIdx), randomGenerator.nextInt(120));
                }
            } else {
                if( hasMiddleName ) {
                    newUser = new User(i, maleNames.get(firstNameIdx), maleNames.get(middleNameIdx), lastNames.get(lastNameIdx), randomGenerator.nextInt(120));
                } else {
                    newUser = new User(i, maleNames.get(firstNameIdx), lastNames.get(lastNameIdx), randomGenerator.nextInt(120));
                }

            }

            userList.add(newUser);
        }

        for (User user : userList) {
            System.out.println(user.toString());
        }
    }


}