import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger count = new AtomicInteger();
    public static void main(String[]args) {
        Instant start = Instant.now();
        for(int i = 0; i < 100; i++) {
            new countThread().start();
        }
        Instant end = Instant.now();
        long dif = Duration.between(start,end).toMillis();
        System.out.println("Count: " + count + " Time: " + dif + " ms");
    }

    public static class countThread extends Thread {
        public void run()
        {
            int counter = 0;
            for(int i = 0; i < 1000000; i++)
                counter++;
            count.getAndAdd(counter);
        }
    }
}
