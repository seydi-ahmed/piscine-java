public class Star extends CelestialObject {
    private double magnitude;

    // Constructeur par défaut
    public Star() {
        super();
        this.magnitude = 0.0;
    }

    // Nouveau constructeur avec paramètres
    public Star(String name, double x, double y, double z, double magnitude) {
        super(name, x, y, z);
        this.magnitude = magnitude;
    }

    // Getter pour magnitude
    public double getMagnitude() {
        return magnitude;
    }

    // Setter pour magnitude
    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

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
        return String.format("%s shines at the %.3f magnitude", getName(), magnitude);
    }

    //******************** MAIN *****************/
    public static void main(String[] args) {
        Star star = new Star();
        Star star2 = new Star();
        Star proxima = new Star("Proxima", 18.389, 832.32, 218, 0.4);
        
        System.out.println(star.toString());
        System.out.println(proxima.toString());
        System.out.println(star.equals(star2));
        System.out.println(star.equals(proxima));
    }

}
