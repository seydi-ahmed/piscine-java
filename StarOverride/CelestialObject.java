import java.util.Objects;

public class CelestialObject {
    // Constant value for astronomical units conversion
    public static final double KM_IN_ONE_AU = 150_000_000;

    // Private properties
    private double x;
    private double y;
    private double z;
    private String name;

    // Default constructor
    public CelestialObject() {
        this.name = "Soleil";
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    // Parameterized constructor
    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getter and setter methods
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Calculate distance between two celestial objects in AU
    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double dx = obj2.getX() - obj1.getX();
        double dy = obj2.getY() - obj1.getY();
        double dz = obj2.getZ() - obj1.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Calculate distance between two celestial objects in kilometers
    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        double distanceInAU = getDistanceBetween(obj1, obj2);
        return distanceInAU * KM_IN_ONE_AU;
    }

    //******************************AJOUT*********************************/
    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    // Overriding equals method
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        
        if (obj == null || this.getClass() != obj.getClass()) return false;
        
        CelestialObject that = (CelestialObject) obj;

        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0 && Double.compare(that.z, z) == 0 && Objects.equals(name, that.name);
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, name);
    }
    //******************************AJOUT*********************************/

}
