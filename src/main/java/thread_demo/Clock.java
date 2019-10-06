package thread_demo;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    private static String mul(String s, int n){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n ; i++)
            builder.append(s);
        return builder.toString();
    }
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    while(true) {
                        String clock = LocalTime.now().format(DateTimeFormatter.ofPattern("kk:mm:ss"));
                        System.out.println(clock);
                        try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.printf("%s", mul("\b", clock.length()));
                    }
                }
        );
        thread.start();
    }
}
