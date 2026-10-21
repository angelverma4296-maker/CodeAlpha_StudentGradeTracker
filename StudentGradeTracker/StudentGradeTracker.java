   import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // ArrayLists to store student data
    static ArrayList<String> studentNames = new ArrayList<>();
    static ArrayList<Double> studentScores = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Method to add a student
    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        double score;

        while (true) {
            System.out.print("Enter score (0 - 100): ");
            score = sc.nextDouble();
            sc.nextLine();

            if (score >= 0 && score <= 100) {
                break;
            } else {
                System.out.println("Invalid score! Please enter a value between 0 and 100.");
            }
        }

        studentNames.add(name);
        studentScores.add(score);

        System.out.println("Student added successfully!");
    }

    // Method to calculate average
    public static double calculateAverage() {
        if (studentScores.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (double score : studentScores) {
            sum += score;
        }

        return sum / studentScores.size();
    }

    // Method to find highest score
    public static double findHighest() {
        if (studentScores.isEmpty()) {
            return 0;
        }

        double highest = studentScores.get(0);

        for (double score : studentScores) {
            if (score > highest) {
                highest = score;
            }
        }

        return highest;
    }

    // Method to find lowest score
    public static double findLowest() {
        if (studentScores.isEmpty()) {
            return 0;
        }

        double lowest = studentScores.get(0);

        for (double score : studentScores) {
            if (score < lowest) {
                lowest = score;
            }
        }

        return lowest;
    }

    // Method to display summary report
    public static void displayReport() {
        if (studentNames.isEmpty()) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("             STUDENT SUMMARY REPORT");
        System.out.println("==============================================");

        System.out.printf("%-5s %-20s %-10s %-10s%n",
                "No.", "Student Name", "Score", "Grade");

        System.out.println("----------------------------------------------");

        for (int i = 0; i < studentNames.size(); i++) {

            String grade = calculateGrade(studentScores.get(i));

            System.out.printf("%-5d %-20s %-10.2f %-10s%n",
                    (i + 1),
                    studentNames.get(i),
                    studentScores.get(i),
                    grade);
        }

        System.out.println("----------------------------------------------");

        System.out.printf("Average Score : %.2f%n", calculateAverage());
        System.out.printf("Highest Score : %.2f%n", findHighest());
        System.out.printf("Lowest Score  : %.2f%n", findLowest());

        System.out.println("==============================================");
    }

    // Method to calculate grade
    public static String calculateGrade(double score) {

        if (score >= 90) {
            return "A+";
        } else if (score >= 80) {
            return "A";
        } else if (score >= 70) {
            return "B";
        } else if (score >= 60) {
            return "C";
        } else if (score >= 50) {
            return "D";
        } else if (score >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    // Main method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("       STUDENT GRADE TRACKER");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Summary Report");
            System.out.println("3. Calculate Average Score");
            System.out.println("4. Find Highest Score");
            System.out.println("5. Find Lowest Score");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayReport();
                    break;

                case 3:
                    if (studentScores.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.printf("Average Score: %.2f%n",
                                calculateAverage());
                    }
                    break;

                case 4:
                    if (studentScores.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.printf("Highest Score: %.2f%n",
                                findHighest());
                    }
                    break;

                case 5:
                    if (studentScores.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.printf("Lowest Score: %.2f%n",
                                findLowest());
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
