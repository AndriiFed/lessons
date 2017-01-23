import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class DeadLock {

  @Test
  public void deadlockTest1() throws Exception {
    Object lock1 = new Object();
    Object lock2 = new Object();

    Runnable a = new Runnable() {
      @Override
      public void run() {
        synchronized (lock1) {
          try {
            TimeUnit.MILLISECONDS.sleep(10);
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
            TimeUnit.MILLISECONDS.sleep(10);
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
    th1.join();

    //TimeUnit.SECONDS.sleep(1);


  }

  @Test
  public void testName() throws Exception {
    Thread.yield();

    Thread current = Thread.currentThread();
    //current.interrupt();
  }

  @Test
  public void testWaitNotify() throws Exception {
    final Object lock = new Object();

    class Waiter implements Runnable {

      @Override
      public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " is going to lock");

        synchronized (lock) {
          try {
            lock.wait();
            System.out.println(name + " has released.");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }

    Thread th1 = new Thread(new Waiter(), "Thread #1");
    Thread th2 = new Thread(new Waiter(), "Thread #2");

    th1.start();
    th2.start();

    TimeUnit.MILLISECONDS.sleep(200);

    synchronized (lock) {
      //lock.notify();
      lock.notifyAll();
    }

    th1.join();
    th2.join();


  }


}
