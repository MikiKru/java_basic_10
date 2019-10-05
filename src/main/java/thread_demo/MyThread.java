package thread_demo;

public class MyThread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args) {
        // utworzenie wątka
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // uruchomienie współbieżengo wykonywania programu
        myThread1.start();
        myThread2.start();
    }
}
