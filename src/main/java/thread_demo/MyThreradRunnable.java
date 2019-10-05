package thread_demo;
import java.util.*;

public class MyThreradRunnable implements Runnable {
    private List<String> names = new ArrayList<>(Arrays.asList(
            "Ala","Ola","Jan","Michał","Adam"
    ));
    @Override
    public void run() {
        for (String name : names){
            System.out.println(Thread.currentThread().getName() +" "+name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreradRunnable th1 = new MyThreradRunnable();

        Thread thread1 = new Thread(th1);
        Thread thread2 = new Thread(th1);
        Thread thread3 = new Thread(th1);

        System.out.println("POCZĄTEK");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();         // metoda join() wywołana z wątku głównego powoduje jego zatrzymanie do czasu zakończenia wątku 1
        thread2.join();         // metoda join() wywołana z wątku głównego powoduje jego zatrzymanie do czasu zakończenia wątku 2
        thread3.join();         // metoda join() wywołana z wątku głównego powoduje jego zatrzymanie do czasu zakończenia wątku 3
        System.out.println("KONIEC");
    }
}
