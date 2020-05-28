package homework1;

public class Apple extends Fruit {
    private static final String name = "Apple";
    Apple(double weight){
        super(weight);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name=" + name +
                " weight=" + getWeight() +
                '}';
    }
}
