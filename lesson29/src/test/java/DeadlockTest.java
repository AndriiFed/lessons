import org.junit.Test;

import java.io.ObjectInput;
import java.util.concurrent.TimeUnit;

public class DeadlockTest {
    @Test
    public void deadlockTest() throws Exception {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable a = new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("A");
                    }
                }
            }
        };

        Runnable b = new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("B");
                    }
                }
            }
        };

        Thread th1 = new Thread(a);
        Thread th2 = new Thread(b);

        th1.start();
        th2.start();

        th1.join();
        th2.join();
    }
}
