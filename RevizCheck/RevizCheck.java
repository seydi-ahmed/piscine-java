public class RevizCheck {
    public static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public String whoAreYou() {
        return "Hello, I am a singleton!";
    }


// **********************************************************************************************************************************

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().whoAreYou());
    }
}
