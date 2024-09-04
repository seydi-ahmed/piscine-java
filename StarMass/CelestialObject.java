public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;
    private int mass; // Propriété ajoutée

    // Constructeur par défaut
    public CelestialObject() {
        this.name = "Soleil";
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.mass = 0; // Initialisation par défaut
    }

    // Constructeur complet
    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    // Getters et setters
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getZ() { return z; }
    public void setZ(double z) { this.z = z; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getMass() { return mass; }
    public void setMass(int mass) { this.mass = mass; }

    public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        double dz = a.getZ() - b.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * Galaxy.KM_IN_ONE_AU;
    }

    @Override
    public String toString() {
        return name + " is positioned at (" + String.format("%.3f", x) + ", " + String.format("%.3f", y) + ", " + String.format("%.3f", z) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CelestialObject that = (CelestialObject) obj;
        return Double.compare(that.x, x) == 0 &&
               Double.compare(that.y, y) == 0 &&
               Double.compare(that.z, z) == 0 &&
               mass == that.mass &&
               name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        long temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + mass;
        return result;
    }
}
