package practice;

import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] marks = new int[3][3]; // Assuming 3 students and 3 subjects

        // Input marks for each student and each subject
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter marks for Student " + (i + 1) + " in Subject " + (char) ('A' + j) + ": ");
                marks[i][j] = scanner.nextInt();
            }
        }

        // Calculate and display total and average for each student
        for (int i = 0; i < 3; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }
            double average = (double) total / 3;
            System.out.println("Total marks for Student " + (i + 1) + ": " + total);
            System.out.println("Average marks for Student " + (i + 1) + ": " + average);
            System.out.println();
        }

        // Calculate and display total and average for each subject
        for (int j = 0; j < 3; j++) {
            int total = 0;
            for (int i = 0; i < 3; i++) {
                total += marks[i][j];
            }
            double average = (double) total / 3;
            System.out.println("Total marks for Subject " + (char) ('A' + j) + ": " + total);
            System.out.println("Average marks for Subject " + (char) ('A' + j) + ": " + average);
            System.out.println();
        }

        scanner.close();
    }
}
