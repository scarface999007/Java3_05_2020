package homework7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int countBeforeSuite = 0;
    static int countAfterSuite = 0;

    public static Comparator<Method> priorityMethod = Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority());

    static Queue<Method> priorityQueue = new PriorityQueue<>(priorityMethod);

    static void start(Class<?> testClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = testClass.getConstructor();
        Object object = constructor.newInstance();
        Method[] methods = testClass.getDeclaredMethods();

        for(Method o : methods){
            if(o.getAnnotation(BeforeSuite.class) != null) {
                countBeforeSuite++;
            }
            if(o.getAnnotation(AfterSuite.class) != null) {
                countAfterSuite++;
            }
        }
        if(countBeforeSuite > 1 || countAfterSuite > 1){
            throw new RuntimeException("Некорректное количество методов с аннотациями BeforeSuite: "
                    + countBeforeSuite + " или AfterSuite: " + countAfterSuite);
        }

        for(Method o : methods){
            if(o.getAnnotation(BeforeSuite.class) != null) {
                Method m = testClass.getDeclaredMethod(o.getName());
                m.invoke(object);
            }
        }

        for(Method o : methods){
            if(o.getAnnotation(Test.class) != null){
                priorityQueue.add(o);
            }
        }

        while (true){
            Method o = priorityQueue.poll();
            if(o == null) break;
            o.invoke(object);
        }


        for(Method o : methods){
            if(o.getAnnotation(AfterSuite.class) != null) {
                Method m = testClass.getDeclaredMethod(o.getName());
                m.invoke(object);
            }
        }
    }


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        start(ArithmeticTest.class);
    }
}
