package homework7;

public class ArithmeticTest {

    private Arithmetic arithmetic;

    @BeforeSuite
    public void init(){
        arithmetic = new Arithmetic();
        System.out.println("Подготовка к тестированию завершена");
    }

    /*@BeforeSuite
    public void init1(){
    }*/

    @Test
    public void testSum(){
        boolean isSuccessed = Assertions.assertEquals(2, arithmetic.sum(1, 1));
        System.out.println("Тест testSum с приоритетом 5 " + (isSuccessed ? "пройден" : "не пройден"));
    }
    @Test(priority = 9)
    public void testDiff(){
        boolean isSuccessed = Assertions.assertEquals(1, arithmetic.diff(2, 1));
        System.out.println("Тест testDiff с приоритетом 9 " + (isSuccessed ? "пройден" : "не пройден"));
    }
    @Test(priority = 2)
    public void testProduct(){
        boolean isSuccessed = Assertions.assertEquals(4, arithmetic.product(2, 2));
        System.out.println("Тест testProduct с приоритетом 2 " + (isSuccessed ? "пройден" : "не пройден"));
    }
    @Test(priority = 4)
    public void testQuotient(){
        boolean isSuccessed = Assertions.assertEquals(2, arithmetic.quotient(4, 2));
        System.out.println("Тест testQuotient с приоритетом 4 " + (isSuccessed ? "пройден" : "не пройден"));
    }

    @AfterSuite
    public void testFinish(){
        System.out.println("Тестирование завершено");
    }

    /*@AfterSuite
    public void testFinish1(){
    }*/

}
