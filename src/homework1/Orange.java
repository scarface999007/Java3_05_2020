package homework1;

public class Orange extends Fruit {
    private static final String name = "Orange";
    Orange(double weight){
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
