import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger count = new AtomicInteger();
    public static void main(String[]args) {
        for(int i = 0; i < 100; i++)
        {
            new countThread().start();
        }
        System.out.println("" + count);
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
