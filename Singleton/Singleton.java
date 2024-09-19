public class Singleton {
    // The unique instance of Singleton, initially null
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
    }

    // Static method to provide global access to the Singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // Lazy initialization
        }
        return instance;
    }

    // A method to return a message, demonstrating the Singleton
    public String whoAreYou() {
        return "Hello, I am a singleton!";
    }
}
