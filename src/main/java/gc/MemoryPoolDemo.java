package gc;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

public class MemoryPoolDemo {
    static boolean keepGoing = true;

    public static void main(String[] args) {
        Thread th = new Thread(() -> {
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            List<MemoryPoolMXBean> pools = ManagementFactory.getMemoryPoolMXBeans();
            while (keepGoing) {
                for (MemoryPoolMXBean pool : pools) {
                    // Display information about each memory pool
                    System.out.printf("Name: %s%n", pool.getName());
                    System.out.printf("Usage: %s%n", pool.getUsage());
                    System.out.printf("Peak Usage: %s%n", pool.getPeakUsage());
                    System.out.printf("Type: %s%n", pool.getType());
                    System.out.println();
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.err.println("Interrupted");
                }
            }
        });
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
