// Factory.java
public class Factory {
    public Product createProduct(String type) {
        switch (type) {
            case "A":
                return new ConcreteProductA();
            case "B":
                return new ConcreteProductB();
            default:
                return null;
        }
    }



// **********************************************************************************************************************************

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().whoAreYou());
    }
}
