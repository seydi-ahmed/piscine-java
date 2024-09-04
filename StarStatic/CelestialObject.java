public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;
    public static final double KM_IN_ONE_AU = 150_000_000;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /******************** Getter and setter for x*************************/
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    /******************** Getter and setter for x*************************/

    /******************** Getter and setter for y*************************/
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    /******************** Getter and setter for y*************************/

    /******************** Getter and setter for z*************************/
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    /******************** Getter and setter for z*************************/

    /******************** Getter and setter for name*************************/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /******************** Getter and setter for name*************************/

    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double dx = obj2.getX() - obj1.getX();
        double dy = obj2.getY() - obj1.getY();
        double dz = obj2.getZ() - obj1.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        double distanceInAU = getDistanceBetween(obj1, obj2);
        return distanceInAU * KM_IN_ONE_AU;
    }

    public static void main(String[] args) {
        CelestialObject defaultStar = new CelestialObject();
        CelestialObject earth = new CelestialObject("Terre", 1.0, 2.0, 2.0);

        System.out.println(CelestialObject.getDistanceBetween(defaultStar, earth));
        System.out.println(CelestialObject.getDistanceBetweenInKm(defaultStar, earth));
        System.out.println(CelestialObject.KM_IN_ONE_AU);
    }

}
