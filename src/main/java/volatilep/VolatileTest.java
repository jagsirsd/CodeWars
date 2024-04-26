package volatilep;

public class VolatileTest {

    private volatile boolean ready = false;
    private int number;

    private class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield(); // Use yield to give writer thread a chance to run
            }
            System.out.println("Read number: " + number);
        }
    }

    private class WriterThread extends Thread {
        public void run() {
            number = 42; // Action A
            ready = true; // Action B (Volatile write)
        }
    }

    public void startTest() {
        new ReaderThread().start();
        new WriterThread().start();
    }

    public static void main(String[] args) {
        new VolatileTest().startTest();
    }
}
