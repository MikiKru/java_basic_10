package thread_demo;

import java.util.Random;

public class ThreadLambda {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++){
                        System.out.println(Thread.currentThread().getName() +" "+(new Random().nextInt(21) - 10));
                        System.out.println(Thread.currentThread().getName() +" "+Thread.currentThread().getState());
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    for (int i = 0; i < 10; i++){
                        System.out.println(Thread.currentThread().getName() +" "+(new Random().nextInt(21) - 10));
                        System.out.println(Thread.currentThread().getName() +" "+Thread.currentThread().getState());
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        System.out.println(thread1.getName() +" "+thread1.getState());
        System.out.println(thread2.getName() +" "+thread2.getState());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(Thread.currentThread().getName() +" "+thread1.getState());
    }
}
