package app;

import app.model.User;
import app.service.UserService;
import app.util.UserPrinter;

import java.util.*;
import java.util.concurrent.CompletableFuture;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static CompletableFuture<Integer> fetchUserId() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(500);
            return 42;
        });
    }

    static CompletableFuture<String> fetchUserName(int id) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(500);
            if (id == 42) return "alice";
            throw new RuntimeException("User not found");
        });
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main_BACK(String[] args) {
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
                    newUser = new User(i, femaleNames.get(firstNameIdx), femaleNames.get(middleNameIdx), lastNames.get(lastNameIdx), randomGenerator.nextInt(42));
                } else {
                    newUser = new User(i, femaleNames.get(firstNameIdx), null, lastNames.get(lastNameIdx), randomGenerator.nextInt(42));
                }
            } else {
                if( hasMiddleName ) {
                    newUser = new User(i, maleNames.get(firstNameIdx), maleNames.get(middleNameIdx), lastNames.get(lastNameIdx), randomGenerator.nextInt(42));
                } else {
                    newUser = new User(i, maleNames.get(firstNameIdx), null, lastNames.get(lastNameIdx), randomGenerator.nextInt(42));
                }

            }

            userList.add(newUser);
        }

        UserPrinter.printUsers(userList);
        UserService service = new UserService();
        Optional<User> user = service.findById(userList, 12);
        System.out.println("User with id = 12: " + user.toString() );
        List<User> listOfAdultUsers = service.findAdults(userList);
        UserPrinter.printUsers(listOfAdultUsers);
        System.out.println("Any user under age: " + service.anyUserUnderAge(userList, 12));
        Map<Integer, List<User>> map = service.groupUsers(userList);
        System.out.println(map);


    }

    public static void main(String[] args) {
        System.out.println("Starting program....");
        CompletableFuture<Void> result = fetchUserId()
                .thenCompose((id) -> {
                    System.out.println("ID: " + id);
                    return fetchUserName(id);
                })
                        .thenAccept(System.out::println)
                .exceptionally(exception -> {
                    System.out.println(exception);
                    return null;
                });
        result.join();




    }


}