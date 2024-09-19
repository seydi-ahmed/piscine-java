public class PerfectNumber {

    public boolean isPerfectNumber(int number) {
        // Check for edge case where number is less than 2
        if (number <= 1) {
            return false;
        }

        int sum = 1; // Start with 1 since 1 is a proper divisor of all numbers

        // Iterate from 2 to sqrt(number)
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) { // If i is a divisor
                sum += i; // Add divisor i
                if (i != number / i) {
                    sum += number / i; // Add the complement divisor if it's different
                }
            }
        }

        // Check if the sum of proper divisors equals the number
        return sum == number;
    }

    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();

        int number1 = 6;
        System.out.println("Is " + number1 + " a perfect number? " + perfectNumber.isPerfectNumber(number1)); // Expected output: true

        int number2 = 28;
        System.out.println("Is " + number2 + " a perfect number? " + perfectNumber.isPerfectNumber(number2)); // Expected output: true

        int number3 = 12;
        System.out.println("Is " + number3 + " a perfect number? " + perfectNumber.isPerfectNumber(number3)); // Expected output: false
    }
}
