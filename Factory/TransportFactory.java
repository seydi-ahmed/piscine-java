public class TransportFactory {
    public static Transport getTransport(String type) {
        switch (type) {
            case "Car":
                return new Car();
            case "Plane":
                return new Plane();
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }
}
