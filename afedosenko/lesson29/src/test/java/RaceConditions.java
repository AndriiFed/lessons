import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class RaceConditions {

  @Test
  public void testName() throws Exception {
    IntWrapper intWrapper = new IntWrapper();

    Runnable runnableTask = new Runnable() {
      @Override
      public void run() {
        for (int i =0; i < 1000; i++) {
          intWrapper.incremetOn(10);
        }
      }
    };


    Thread[] threads = new Thread[100];
    for (int i = 0; i < 100; i++) {
      threads[i] = new Thread(runnableTask);
      threads[i].start();
      threads[i].join();
    }


    TimeUnit.SECONDS.sleep(1);
    System.out.println(intWrapper.get());

  }

  @Test
  public void testName3() throws Exception {
    IntWrapper2 intWrapper = new IntWrapper2();

    Runnable runnableTask = new Runnable() {
      @Override
      public void run() {
        for (int i =0; i < 1000; i++) {
          intWrapper.incremetOn(10);
        }
      }
    };


    Thread[] threads = new Thread[100];
    for (int i = 0; i < 100; i++) {
      threads[i] = new Thread(runnableTask);
      threads[i].start();
      threads[i].join();
    }


    TimeUnit.SECONDS.sleep(1);
    System.out.println(intWrapper.get());

  }

  @Test
  public void testName4() throws Exception {
    IntWrapper intWrapper = new IntWrapper();
    Object lock = new Object();

    Runnable runnableTask = new Runnable() {
      @Override
      public void run() {
        for (int i =0; i < 1000; i++) {
          synchronized (lock) {  // or synchronized (intWrapper) {
            intWrapper.incremetOn(10);
          }
        }
      }
    };


    Thread[] threads = new Thread[100];
    for (int i = 0; i < 100; i++) {
      threads[i] = new Thread(runnableTask);
      threads[i].start();
      threads[i].join();
    }

    TimeUnit.SECONDS.sleep(1);
    System.out.println(intWrapper.get());

  }




  class IntWrapper {
    private int i;

    public int get() {
     return i;
    }

    public void incremetOn(int m) {
      i += m;
    }

  }
  class IntWrapper2 {
    private int i;

    synchronized public int get() {
     return i;
    }

    synchronized void incremetOn(int m) {
      i += m;
    }

  }


}
