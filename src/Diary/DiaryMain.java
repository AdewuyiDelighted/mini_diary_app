package Diary;

import java.util.Scanner;

public class DiaryMain {
    private static Diary diary;
     static MultiThread multiThread = new MultiThread();

    public static void main(String[] args) {
        display();
    }


    public static void display() {
        print("""
                Welcome""");
        int createDiaryResponse = Integer.parseInt(input("Enter 1 to create diary"));
        if (createDiaryResponse == 1) {
            String username = input("Enter your username");
            String password = input("Enter your password");
            createDiary(username, password);
            print("Diary created successfully");
            addEntryMenu();
        } else {
            display();
        }
    }

    public static void addEntryMenu() {
        String addEntryAnswer = input("Enter 1 to create an entry");
        if (addEntryAnswer.equals("1")) {
            multiThread.run();
            mainMenu();
            multiThread.run();
        }


    }

    public static void mainMenu() {
        String option = input("""
                Enter 1 to unlock diary
                Enter 2 to write in your new entry
                Enter 3 to find an entry in you diary
                Enter 4 to update dairy
                Enter 5 to delete entry
                Enter 6 to lock diary
                Enter 7 to exit
                """);
        switch (option) {
            case "1" -> unlockDiary();
            case "2" -> createAnEntry();
            case "3" -> findAnEntry();
            case "4" -> updateAnEntry();
            case "5" -> deleteEntry();
            case "6" -> lockDiary();
            case "7" -> exit();
        }
    }


    public static void createDiary(String username, String password) {
        diary = new Diary(username, password);

    }

    public static void unlockDiary() {
        String password = input("Enter your password");
        diary.unlock(password);
        multiThread.run();
        if (!diary.isLocked()) System.out.println("Diary unlocked");
        mainMenu();
    }

    public static void createAnEntry() {
        if (!diary.isLocked()) {
            String title = input("Enter the title of your new entry");
            String body = input("Enter the body of your diary");
            diary.createEntry(title, body);
            Entry entry = new Entry(diary.generateId(), title, body);
            multiThread.run();
            print(entry.toString());
            multiThread.run();
            mainMenu();
        } else {
            multiThread.run();
            print("unlock diary");
            mainMenu();

        }
    }

    public static void findAnEntry() {
        if (!diary.isLocked()) {
            String entryId = input("Enter the id of the entry you need");
            Entry entry = diary.findEntryById(entryId);
            multiThread.run();
            print(entry.toString());
            multiThread.run();
            mainMenu();
        } else {
            multiThread.run();
            print("Unlock diary ");
            mainMenu();
        }
    }

    public static void updateAnEntry() {
        if (!diary.isLocked()) {
            String entryId = input("Enter the Entry id of the entry you want to update");
            String newTitle = input("Enter the new title");
            String newBody = input("Continue writing");
            diary.updateEntry(entryId, newTitle, newBody);
            multiThread.run();
            print("Entry updated successfully");
            mainMenu();

        } else {
            multiThread.run();
            print("Unlock diary ");
            mainMenu();

        }
    }

    public static void deleteEntry() {
        if (!diary.isLocked()) {
            String entryId = input("Enter the id of the entry you wan to delete");
            diary.deleteEntry(entryId);
            multiThread.run();
            print("Entry deleted");
            mainMenu();

        } else {
            multiThread.run();
            print("Unlock diary ");
            mainMenu();

        }
    }

    public static void exit() {
        System.exit(0);

    }

    public static void lockDiary() {
        diary.lock();
        multiThread.run();
        if (diary.isLocked()) print("Diary locked");
        mainMenu();
    }


    private static String input(String message) {
        Scanner scanner = new Scanner(System.in);
        print(message);
        return scanner.nextLine();

    }

    private static void print(String message) {
        System.out.println(message);
    }

}
