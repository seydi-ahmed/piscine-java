public class PerfectNumber {

    public boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }

        int sum = 1;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }

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
