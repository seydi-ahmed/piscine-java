import java.lang.Math;

public class AreaCalculator {
    public double calculate(double radius) {
        double area = Math.PI*radius*radius;
        return Math.round(area*100.0)/100.0;
    }

    public double calculate(double width, double height) {
        double area = width*height;
        return Math.round(area*100.0)/100.0;
    }

    public double calculate(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            double area = (base * height) / 2;
            return Math.round(area*100.0)/100.0;
        }
        return -1;
    }

    public double calculate(double side, boolean isSquare) {
        if (isSquare) {
            double area = side*side;
            return (area*100.0)/100.0;
        }
        return -1;
    }

    // ***************************** MAIN *****************************

    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        // Test calculate area of a circle
        double circleArea = calculator.calculate(5.0);
        System.out.println("Area of circle: " + circleArea);

        // Test calculate area of a rectangle
        double rectangleArea = calculator.calculate(4.0, 6.0);
        System.out.println("Area of rectangle: " + rectangleArea);

        // Test calculate area of a triangle
        double triangleArea = calculator.calculate(4.0, 6.0, true);
        System.out.println("Area of triangle: " + triangleArea);

        // Test calculate area of a square
        double squareArea = calculator.calculate(4.0, true);
        System.out.println("Area of square: " + squareArea);
    }
}