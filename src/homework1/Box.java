package homework1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> arrayList;
    private double weight;

    public Box() {
        this.arrayList = new ArrayList<>();
        this.weight = 0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void addFruit(T fruit){
        weight += fruit.getWeight();
        arrayList.add(fruit);
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public boolean compare(Box<T> box){
        return this.weight == box.weight;
    }




    public Box<T> pourIntoThisBox(Box<T> box){
        this.getArrayList().addAll(box.getArrayList());
        this.setWeight(this.getWeight() + box.getWeight());
        box.getArrayList().clear();
        box.setWeight(0);
        return this;
    }

}
