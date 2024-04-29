import java.util.ArrayList;
import java.util.List;

public class GarbageCreatorRunnable implements Runnable {

    private final int rand;
    private final int SIZE;
    void extracted(boolean runInNewThread) { //throws InterruptedException {
        int rand = ((int) (Math.random() * 100) % 10);
        if(runInNewThread) {
            Thread th = new Thread(new GarbageCreatorRunnable(rand, SIZE));
            th.start();
            //th.join();
        } else {
            new GarbageCreatorRunnable(rand, SIZE).run();
        }
    }
    public GarbageCreatorRunnable(int rand, int size) {
        this.rand = rand;
        SIZE = size;
    }

    @Override
    public void run() {
        createGarbage(rand * SIZE);
        System.out.print("\t\tGoing to sleep for:" + rand);
//        try {
//            Thread.sleep(rand);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void createGarbage(final int size) {
        int[] array = new int[size];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i += size / 100) {
            array[i] = i;
            list.add(array[i]);
        }
        list.stream().filter(i -> i==5).forEach(System.out::print);
    }
}
