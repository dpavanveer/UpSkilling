package practice;

public class ArmstrongNumberRange {
    public static void main(String[] args) {
        System.out.println("Armstrong numbers in the range of 100 to 999 are:");
        for (int number = 100; number <= 999; number++) {
            if (isArmstrongNumber(number)) {
                System.out.println(number);
            }
        }
    }

    static boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 3);
            number /= 10;
        }

        return sum == originalNumber;
    }
}
