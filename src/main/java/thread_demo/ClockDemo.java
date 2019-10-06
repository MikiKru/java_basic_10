package thread_demo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockDemo {
    private static String mul(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++)
            builder.append(s);
        return builder.toString();
    }
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    while (true) {
                        String foo = LocalTime.now().format(DateTimeFormatter.ofPattern("kk:mm:ss"));
                        System.out.printf(foo);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        System.out.printf("%s", mul("\b", foo.length()));
                    }
                }
        );
        thread.start();

    }
}
