import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadStatesTest {
    @Test
    public void test() throws Exception {
        Thread.yield();
        Thread currentThread = Thread.currentThread();
        currentThread.stop();
        currentThread.interrupt();
    }

    private final Object lock = new Object();

    class Waiter implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            synchronized (lock) {
                System.out.println(name + " is acquiring the lock");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " just released the lock");
            }
        }
    }

    @Test
    public void testWaitNotify() throws Exception {
        Runnable waiter1 = new Waiter();
        Runnable waiter2 = new Waiter();

        Thread th1 = new Thread(waiter1, "waiter #1");
        Thread th2 = new Thread(waiter2, "waiter #2");

        th1.start();
        th2.start();

        TimeUnit.MICROSECONDS.sleep(200);

        synchronized (lock) {
            //lock.notify();
            lock.notifyAll();
        }

        th1.join();
        th2.join();
    }
}
