public class ArmstrongNumber {
    public boolean isArmstrong(int number) {
        String numStr = Integer.toString(number);
        int numDigits = numStr.length();
        int sum = 0;

        for (char c : numStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            sum += Math.pow(digit, numDigits);
        }

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


// ArrmStrongNumber