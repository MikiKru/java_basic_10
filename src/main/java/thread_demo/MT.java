package thread_demo;

public class MT  {
    Thread t1;
    Thread t2;

    public void thread1Action(){
        t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.println("aaa");
            }
        });
    }
    public void thread2Action(){
        t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.println("bbb");
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        MT mt = new MT();
        mt.thread1Action();
        mt.thread2Action();
        mt.t1.start();
        mt.t2.start();
    }
}
