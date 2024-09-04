public class Star extends CelestialObject {
    private double magnitude;

    // Constructeur par défaut
    public Star() {
        super();
        this.magnitude = 0.0;
    }

    // Constructeur complet
    public Star(String name, double x, double y, double z, double magnitude, int mass) {
        super(name, x, y, z, mass);
        this.magnitude = magnitude;
    }

    // Getters et setters
    public double getMagnitude() { return magnitude; }
    public void setMagnitude(double magnitude) { this.magnitude = magnitude; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Star star = (Star) obj;
        return Double.compare(star.magnitude, magnitude) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp = Double.doubleToLongBits(magnitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getName() + " shines at the " + String.format("%.3f", magnitude) + " magnitude";
    }
}
