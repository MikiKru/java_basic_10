package thread_demo;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    private static String mul(String s, int n){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n ; i++)
            // wykorzystujemy obiekt klasy StringBuilder do edycji napisu
            builder.append(s);
        return builder.toString();
    }
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    while(true) {
                        // zapisujemy reprezentację czasu do String
                        String clock = LocalTime.now().format(DateTimeFormatter.ofPattern("kk:mm:ss.S"));
                        // wyświetlamy na konsoli string XX:XX:XX
                        System.out.printf(clock);
                        try {
                            // usypiamy wątkek na czas 100ms -> 0.1s
                            Thread.currentThread().sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // wypisujemy string który usuwa -> \b backspace tyle znakówi ile ma zmienna clock XX:XX:XX
                        System.out.printf("%s", mul("\b", clock.length()));
                    }
                }
        );
        thread.start();
    }
}
