public class GCDemoEden {
    public static final int SIZE = 1 * 1024;
    private static final boolean runInNewThread = true;
    public static void main(String[] args) throws InterruptedException {
        GarbageCreatorRunnable demo = new GarbageCreatorRunnable(0, SIZE);
        while (true) {
            demo.extracted(runInNewThread);
        }
    }

}

