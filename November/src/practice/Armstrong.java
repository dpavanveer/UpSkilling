package practice;

import java.util.Scanner;

public class Armstrong {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input the number
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();

	        // Check if the number is Armstrong
	        if (isArmstrongNumber(number)) {
	            System.out.println(number + " is an Armstrong number.");
	        } else {
	            System.out.println(number + " is not an Armstrong number.");
	        }

	        scanner.close();
	    }

	    // Function to check if a number is Armstrong
	    static boolean isArmstrongNumber(int number) {
	        int originalNumber, remainder, result = 0, n = 0;

	        originalNumber = number;

	        // Assign the original number into a temporary variable
	        originalNumber = number;

	        // Count the number of digits
	        while (originalNumber != 0) {
	            originalNumber /= 10;
	            ++n;
	        }

	        originalNumber = number;

	        // Calculate the sum of nth power of each digit
	        while (originalNumber != 0) {
	            remainder = originalNumber % 10;
	            result += Math.pow(remainder, n);
	            originalNumber /= 10;
	        }

	        // Check if the sum is equal to the original number
	        return result == number;
	    }
	}
