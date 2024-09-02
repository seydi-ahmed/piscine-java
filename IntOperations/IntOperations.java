public class IntOperations {
    public static int addTwoIntegers(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }
    public static int subtractTwoIntegers(int a, int b) {
        System.out.println(a - b);
        return a - b;
    }
    public static int multiplyTwoIntegers(int a, int b) {
        System.out.println(a * b);
        return a * b;
    }
    public static int divideTwoIntegers(int a, int b) {
        System.out.println(a / b);
        return a / b;
    }


    public static void main(String[] args) {
        addTwoIntegers(2, 3);
        subtractTwoIntegers(2, 3);
        multiplyTwoIntegers(2, 3);
        divideTwoIntegers(2, 3);
    }
}
