import java.text.DecimalFormat;

public class AreaCalculator {
    
    // Calcul de l'aire d'un cercle
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // Calcul de l'aire d'un cercle
    public double calculate(double radius) {
        double area = Math.PI * radius * radius;
        return Double.parseDouble(df.format(area));
    }

    // Calcul de l'aire d'un rectangle
    public double calculate(double width, double height) {
        double area = width * height;
        return Double.parseDouble(df.format(area));
    }

    // Calcul de l'aire d'un triangle
    public double calculate(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            double area = 0.5 * base * height;
            return Double.parseDouble(df.format(area));
        }
        // Si le booléen isTriangle est faux, il est en fait destiné à signaler une erreur.
        // Mais pour la signature, on suppose que si ce n'est pas un triangle, il ne doit pas être appelé ici.
        return -1;
    }

    // Calcul de l'aire d'un carré
    public double calculate(double side, boolean isSquare) {
        if (isSquare) {
            double area = side * side;
            return Double.parseDouble(df.format(area));
        }
        // Si le booléen isSquare est faux, il est en fait destiné à signaler une erreur.
        // Mais pour la signature, on suppose que si ce n'est pas un carré, il ne doit pas être appelé ici.
        return -1;
    }

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
