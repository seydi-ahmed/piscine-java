public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super();
        this.magnitude = 0.0;
    }

    public double getMagnitude() {
        return this.magnitude;
    }

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