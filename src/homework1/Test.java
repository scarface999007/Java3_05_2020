package homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("Поменять местами два элемента");
        Integer [] arrSwapI = {10, 9, 11};
        System.out.println(Arrays.toString(arrSwapI));
        System.out.println(Arrays.toString(swapTwoElement(arrSwapI, 0, 2)));
        Double [] arrSwapD = {20.0, 9.0, 31.0};
        System.out.println(Arrays.toString(arrSwapD));
        System.out.println(Arrays.toString(swapTwoElement(arrSwapD, 0, 2)));
        System.out.println("Сконвертировать массив в ArrayList");
        Integer [] arrI = {1, 2, 3};
        System.out.println(convertToArray(arrI));
        Double [] arrD = {4.0, 5.0, 6.0};
        System.out.println(convertToArray(arrD));


        Box<Apple> boxApple = new Box<>();
        boxApple.addFruit(new Apple(1.0));
        boxApple.addFruit(new Apple(2.0));
        boxApple.addFruit(new Apple(3.0));

        Box<Apple> boxApple1 = new Box<>();
        boxApple1.addFruit(new Apple(6.0));

        System.out.println("Первая коробка с яблоками" + boxApple.getArrayList());
        System.out.println("Вторая коробка с яблоками" + boxApple1.getArrayList());

        Box<Orange> boxOrange = new Box<>();
        boxOrange.addFruit(new Orange(4.0));
        boxOrange.addFruit(new Orange(5.0));
        boxOrange.addFruit(new Orange(6.0));

        Box<Orange> boxOrange1 = new Box<>();
        boxOrange1.addFruit(new Orange(16.0));

        System.out.println("Первая коробка с апельсинами" + boxOrange.getArrayList());
        System.out.println("Вторая коробка с апельсинами" + boxOrange1.getArrayList());

        System.out.println(boxOrange.getArrayList());

        System.out.println("Равенство коробок с яблоками = " + boxApple.compare(boxApple1));
        System.out.println("Равенство коробок с апельсинами = " + boxOrange.compare(boxOrange1));

        boxApple1.pourIntoThisBox(boxApple);
        System.out.println("Коробка, в которую пересыпали = " + boxApple1.getArrayList() + " Вес = " + boxApple1.getWeight());
        System.out.println("Коробка, из которой пересыпали = " + boxApple.getArrayList() + " Вес = " + boxApple.getWeight());

    }


    public static <T> T[] swapTwoElement(T [] array, int firstElement, int secondElement) {
        if(firstElement < 0 || firstElement > array.length){
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + firstElement);
        }
        if(secondElement < 0 || secondElement > array.length){
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + secondElement);
        }
        T element = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = element;
        return  array;
    }

    public static <T> ArrayList<T> convertToArray(T [] array){
        ArrayList<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        return list;
    }

}
