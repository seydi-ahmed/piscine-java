public class TestCode {
    public static int addTwoIntegers(int a, int b) {
        return a + b;
    }
    public static int subtractTwoIntegers(int a, int b) {
        return a - b;
    }
    public static int multiplyTwoIntegers(int a, int b) {
        return a * b;
    }
    public static int divideTwoIntegers(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("Add");
        System.out.println(addTwoIntegers(1, 2));
        System.out.println(addTwoIntegers(15, 68));

        System.out.println("Subtract");
        System.out.println(subtractTwoIntegers(4, 1));
        System.out.println(subtractTwoIntegers(10, 23));

        System.out.println("Multiply");
        System.out.println(multiplyTwoIntegers(3, 6));
        System.out.println(multiplyTwoIntegers(12, 11));

        System.out.println("Divide");
        System.out.println(divideTwoIntegers(8, 2));
        System.out.println(divideTwoIntegers(13, 4));
    }

}