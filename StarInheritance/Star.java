public class Star extends CelestialObject {
    private double magnitude;

    // Default constructor which calls the default constructor of CelestialObject
    public Star() {
        super();  // Call the parent class's constructor
        this.magnitude = 0.0;  // Initialize magnitude to 0.0
    }

    // Getter for magnitude
    public double getMagnitude() {
        return this.magnitude;
    }

    // Setter for magnitude
    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public static void main(String[] args) {
        Star star = new Star();
        
        System.out.println(star.getName());
        System.out.println(star.getX());
        System.out.println(star.getY());
        System.out.println(star.getZ());
        System.out.println(star.getMagnitude());
    }

}