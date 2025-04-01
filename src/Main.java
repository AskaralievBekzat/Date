import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Date> dateList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Date Management System =====");
            System.out.println("1. Create a new date");
            System.out.println("2. Update an existing date");
            System.out.println("3. Print a date");
            System.out.println("4. Get the day of the week");
            System.out.println("5. Calculate difference between two dates");
            System.out.println("6. Sort and display all stored dates");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> createDate();
                case 2 -> updateDate();
                case 3 -> printDate();
                case 4 -> getDayOfWeek();
                case 5 -> calculateDifference();
                case 6 -> sortAndDisplayDates();
                case 7 -> {
                    System.out.println("Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void createDate() {
        System.out.print("Enter day: ");
        int day = scanner.nextInt();
        System.out.print("Enter month: ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        try {
            Date newDate = new Date(day, month, year);
            dateList.add(newDate);
            System.out.println("Date added successfully: " + newDate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateDate() {
        if (dateList.isEmpty()) {
            System.out.println("No dates available to update.");
            return;
        }
        System.out.println("Choose a date to update:");
        displayDates();

        int index = scanner.nextInt();
        if (index < 1 || index > dateList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Enter new day: ");
        int day = scanner.nextInt();
        System.out.print("Enter new month: ");
        int month = scanner.nextInt();
        System.out.print("Enter new year: ");
        int year = scanner.nextInt();

        dateList.get(index - 1).updateDate(day, month, year);
        System.out.println("Date updated successfully.");
    }

    private static void printDate() {
        if (dateList.isEmpty()) {
            System.out.println("No dates available.");
            return;
        }
        System.out.println("Choose a date to print:");
        displayDates();

        int index = scanner.nextInt();
        if (index < 1 || index > dateList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        dateList.get(index - 1).printDate();
    }

    private static void getDayOfWeek() {
        if (dateList.isEmpty()) {
            System.out.println("No dates available.");
            return;
        }
        System.out.println("Choose a date to get the day of the week:");
        displayDates();

        int index = scanner.nextInt();
        if (index < 1 || index > dateList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Day of the week: " + dateList.get(index - 1).getDayOfWeek());
    }

    private static void calculateDifference() {
        if (dateList.size() < 2) {
            System.out.println("At least two dates are required to calculate a difference.");
            return;
        }
        System.out.println("Choose the first date:");
        displayDates();

        int index1 = scanner.nextInt();
        if (index1 < 1 || index1 > dateList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("Choose the second date:");
        int index2 = scanner.nextInt();
        if (index2 < 1 || index2 > dateList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        int diff = dateList.get(index1 - 1).calculateDifference(dateList.get(index2 - 1));
        System.out.println("Difference in days: " + diff);
    }

    private static void sortAndDisplayDates() {
        if (dateList.isEmpty()) {
            System.out.println("No dates available.");
            return;
        }
        Collections.sort(dateList);
        System.out.println("Sorted Dates:");
        for (Date date : dateList) {
            System.out.println(date);
        }
    }

    private static void displayDates() {
        for (int i = 0; i < dateList.size(); i++) {
            System.out.println((i + 1) + ". " + dateList.get(i));
        }
        System.out.print("Enter the number of your choice: ");
    }
}