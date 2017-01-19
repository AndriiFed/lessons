import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ThreadsTest {
    @Test
    public void simpleThread() throws Exception {
        Runnable runnableTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        Thread th = new Thread(runnableTask);
        th.start();
        th.join();
    }

    @Test
    public void printNumbersWithPriority() throws Exception {
        class PrintNumberTask implements Runnable {
            private int i;

            public PrintNumberTask(int i) {
                this.i = i;
            }

            @Override
            public void run() {
                /*try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(i);
            }
        }

        for (int i = 0; i < 100; i++) {
            Thread th = new Thread(new PrintNumberTask(i));
            if (i % 2 == 0) {
                th.setPriority(Thread.MAX_PRIORITY);
            } else {
                th.setPriority(Thread.MIN_PRIORITY);
            }
            th.start();
        }

        TimeUnit.SECONDS.sleep(1);
    }
}
