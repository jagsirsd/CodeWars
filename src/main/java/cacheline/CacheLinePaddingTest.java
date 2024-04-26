package cacheline;

public class CacheLinePaddingTest {

    // Assuming a cache line is 64 bytes, a long in Java is 8 bytes.
    // We pad with 7 longs (56 bytes) to likely ensure the next variable is on a different cache line.
    private static class PaddedCounter {
        long pad0, pad1, pad2, pad3, pad4, pad5, pad6; // padding
         long counter = 0;
          long pad7, pad8, pad9, pad10, pad11, pad12, pad13; // additional padding
           //boolean flag = false;
    }

    private static class Counter {
        long pad0, pad1, pad2, pad3, pad4, pad5, pad6; // padding
        long counter = 0;
        long pad7, pad8, pad9, pad10, pad11, pad12, pad13; // additional padding
    }

    private static void testCounter(final PaddedCounter counter) throws InterruptedException {
        long size = Long.MAX_VALUE >>> 34;
        Thread incrementer1 = new Thread(() -> {
            for (long i = 0; i < size ; i++) {
                counter.counter++;
                //counter.pad7++;
//                if(i %1_00 == 0) {
//                    counter.flag = true;
//                }
            }
        });

        Thread incrementer2 = new Thread(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            for (long i = 0; i < size; i++) {
                //counter.counter++;
                counter.pad7++;
                //if(i %1_00 == 0) {
                   //counter.flag = true;
                //}
            }
        });
        //System.out.println(" start padded " + counter.counter);
        long start = System.nanoTime();
        incrementer1.start();
        incrementer2.start();
        incrementer1.join();
        long end = System.nanoTime();
        System.out.println(" padded " + counter.counter);
        incrementer2.join();
        logTime(end, start);

        end = System.nanoTime();
        System.out.println(" padded " + counter.pad7);
        logTime(end, start);
    }

    private static void logTime(long end, long start) {
        System.out.println("Padded Duration: " + (end - start) / 1_000_000 + " ms");
    }

    private static void testCounter(final Counter counter) throws InterruptedException {
        long size = Long.MAX_VALUE >>> 37;
        Thread incrementer1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                counter.counter++;
            }
        });

        Thread incrementer2 = new Thread(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            for (int i = 0; i < size; i++) {
                counter.counter++;
            }
        });

        //System.out.println(" start no padding " + counter.counter);
        long start = System.nanoTime();
        incrementer1.start();
        incrementer2.start();
        incrementer1.join();
        incrementer2.join();
        long end = System.nanoTime();
        System.out.println("End non padding: " + counter.counter);

        System.out.println("Duration: " + (end - start) / 1_000_000 + " ms");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            //System.out.println("Testing normal counter:");
            testCounter(new Counter());

            //System.out.println("Testing padded counter:");
            testCounter(new PaddedCounter());
        }
    }
}

