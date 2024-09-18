public class DriverFactory {
    public static Driver getDriver(String type) {
        switch (type) {
            case "Car":
                return new CarDriver();
            case "Plane":
                return new PlaneDriver();
            default:
                throw new IllegalArgumentException("Unknown driver type: " + type);
        }
    }
}
