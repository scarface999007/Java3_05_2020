package homework4;

public class Test {

    private final static Object monitor = new Object();
    private volatile static char currentLetter = 'A';

    public static void main(String[] args) {
        Thread tA = new Thread(()->{
            synchronized (monitor) {
                try{
                    for (int i = 0; i < 5; i++) {
                        while (currentLetter != 'A'){
                            monitor.wait();
                        }
                        System.out.print('A');
                        currentLetter = 'B';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread tB = new Thread(()->{
            synchronized (monitor){
                try{
                    for (int i = 0; i < 5; i++) {
                        while (currentLetter != 'B'){
                            monitor.wait();
                        }
                        System.out.print('B');
                        currentLetter = 'C';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread tC = new Thread(()->{
            synchronized (monitor){
                try{
                    for (int i = 0; i < 5; i++) {
                        while (currentLetter != 'C'){
                            monitor.wait();
                        }
                        System.out.print('C');
                        currentLetter = 'A';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tA.start();
        tB.start();
        tC.start();
    }
}
