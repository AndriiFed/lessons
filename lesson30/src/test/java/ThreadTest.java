import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    private final Object lock = new Object();

    @Test
    public void testWaitNotify() throws Exception {
        class Waiter implements Runnable {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                synchronized (lock) {
                    System.out.println(name + " has acquired the lock");
                    try {
                        lock.wait();
                       // TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + " has released the lock");
                }
            }
        }

        Runnable waiter1 = new Waiter();
        Runnable waiter2 = new Waiter();

        Thread th1 = new Thread(waiter1, "waiter #1");
        Thread th2 = new Thread(waiter2, "waiter #2");

        th1.start();
        th2.start();

        TimeUnit.MICROSECONDS.sleep(300);

        synchronized (lock) {
            //lock.notify();
            lock.notifyAll();
        }

        th1.join();
        th2.join();
    }
}
