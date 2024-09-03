public class ArmstrongNumber {
    public boolean isArmstrong(int number) {
        // Convert the number to string to get each digit
        String numStr = Integer.toString(number);
        int numDigits = numStr.length(); // Number of digits in the number
        int sum = 0;

        // Calculate the sum of each digit raised to the power of numDigits
        for (char c : numStr.toCharArray()) {
            int digit = Character.getNumericValue(c); // Convert character to integer
            sum += Math.pow(digit, numDigits);
        }

        // Check if the sum equals the original number
        return sum == number;
    }

    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();

        // Test case 1
        int number1 = 153;
        System.out.println("Is " + number1 + " an Armstrong number? " + armstrongNumber.isArmstrong(number1)); // Expected output: true

        // Test case 2
        int number2 = 123;
        System.out.println("Is " + number2 + " an Armstrong number? " + armstrongNumber.isArmstrong(number2)); // Expected output: false

        // Test case 3
        int number3 = 9474;
        System.out.println("Is " + number3 + " an Armstrong number? " + armstrongNumber.isArmstrong(number3)); // Expected output: true
    }
}
