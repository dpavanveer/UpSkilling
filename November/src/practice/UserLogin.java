package practice;

import java.util.Scanner;

public class UserLogin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int maxAttempts = 3;
		int attempts = 0;

		String validUsername = "Pavan";
		String validPassword = "Pavan@123";

		while (attempts < maxAttempts) {
			System.out.print("Enter your username: ");
			String enteredUsername = scanner.nextLine();

			System.out.print("Enter your password: ");
			String enteredPassword = scanner.nextLine();

			if (isValidUser(enteredUsername, enteredPassword, validUsername, validPassword)) {
				System.out.println("Welcome, " + enteredUsername + "!");
				break;
			} else {
				attempts++;
				System.out.println("Invalid username or password. Attempts remaining: " + (maxAttempts - attempts));
			}
		}

		if (attempts == maxAttempts) {
			System.out.println("Login attempts exceeded. Account locked.");
		}

		scanner.close();
	}

	static boolean isValidUser(String enteredUsername, String enteredPassword, String validUsername,
			String validPassword) {
		return enteredUsername.equals(validUsername) && enteredPassword.equals(validPassword);
	}
}
