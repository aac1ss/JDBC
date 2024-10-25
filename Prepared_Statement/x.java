package JDBC.Prepared_Statement;

public class x {
    // Shared variable
    private static int a = 0;

    public static void main(String[] args) {
        // Create an array to hold thread references
        Thread[] threads = new Thread[10];

        // Create and start 10 threads
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                // Increment the shared variable
                for (int j = 0; j < 1000; j++) { // Increment multiple times for demonstration
                    a++; // Increment without synchronization
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the final value of a
        System.out.println("Final value of a: " + a);
    }
}