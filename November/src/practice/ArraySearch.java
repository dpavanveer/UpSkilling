package practice;

import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        int[] numbers = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to search: ");
        int searchNumber = scanner.nextInt();

        boolean found = false;

        for (int number : numbers) {
            if (number == searchNumber) {
                found = true;
                break;
            }
        }

        System.out.println(found ? searchNumber + " is present in the array." : searchNumber + " is not present in the array.");

        scanner.close();
    }
}
