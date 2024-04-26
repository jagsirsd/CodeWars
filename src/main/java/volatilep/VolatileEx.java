package volatilep;

public class VolatileEx {
    boolean b = false;
    long a = 0;

    public void produce() throws InterruptedException {
        //b and a are in lock step.
        a += 1;
        if(a % 2 == 0) {
            //a is even
            b = false;
        } else {
            b = true;
        }
    }

    public void consume() throws InterruptedException {
        if (b == true) {
            if(a % 2 == 1) {
                //A should be odd
            } else {
                System.err.print("Not All Good" + a + " " + b);
            }
        } else {
            if(a % 2 == 0) {
                //a should be even
            } else {
                System.err.print("Not All Good" + a + " " + b);
            }
        }
    }

    public static void main(String[] args) {
        VolatileEx pc = new VolatileEx();
        int size = 10000;

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < size; i++) {
                    pc.produce();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < size; i++) {
                    pc.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}


