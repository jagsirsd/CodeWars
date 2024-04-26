package concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerWithSemaphore {
    private static final int CAPACITY = 5;
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore items = new Semaphore(0);
    private final Semaphore space = new Semaphore(CAPACITY);

    private Queue<Integer> queue = new LinkedList<>();
    
    public void produce() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            space.acquire(); // Wait for space to become available
            mutex.acquire(); // Acquire the mutex to access the queue
            queue.add(i);
            System.out.println("Produced: " + i);
            mutex.release(); // Release the mutex
            items.release(); // Signal that an item is available
        }
    }

    public void consume() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            items.acquire(); // Wait for an item to become available
            mutex.acquire(); // Acquire the mutex to access the queue
            int item = queue.poll();
            System.out.println("Consumed: " + item);
            mutex.release(); // Release the mutex
            space.release(); // Signal that space is available
        }
    }

    public static void main(String[] args) {
        ProducerConsumerWithSemaphore pc = new ProducerConsumerWithSemaphore();

        Thread producer = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
