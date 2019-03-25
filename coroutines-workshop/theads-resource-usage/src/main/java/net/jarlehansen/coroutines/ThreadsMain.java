package net.jarlehansen.coroutines;

import java.io.IOException;

public class ThreadsMain {

    public static final int NUMBER_OF_THREADS = 100_000;

    public static void main(String[] args) throws IOException {
        System.out.println("Push any key to start threads");
        System.in.read();

        System.out.println("Started");
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000L);
                    System.out.print(".");
                } catch (InterruptedException ignored) {
                }
            };

            new Thread(runnable).start();
        }

        System.out.println("\n\nFinished");
    }
}
