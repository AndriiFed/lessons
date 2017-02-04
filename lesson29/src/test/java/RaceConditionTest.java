import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RaceConditionTest {
    class IntWrapper {
        public int get() {
            return i;
        }

        public void incrementOn(int i) {
            this.i += i;
        }

        private int i;
    }

    @Test
    public void test1() throws Exception {
        IntWrapper intWrapper = new IntWrapper();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intWrapper.incrementOn(10);

            }
        };
        for (int i = 0; i < 100; i++) {
            Thread th = new Thread(task);
            th.start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(intWrapper.get());
    }

    @Test
    public void test2() throws Exception {
        IntWrapper intWrapper = new IntWrapper();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    intWrapper.incrementOn(10);
                }

            }
        };

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        System.out.println(intWrapper.get());
    }

    @Test
    public void test3() throws Exception {
        class IntWrapper {
            public int get() {
                return i;
            }

            synchronized public void incrementOn(int i) {
                this.i += i;
            }

            private int i;
        }

        IntWrapper intWrapper = new IntWrapper();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    intWrapper.incrementOn(10);
                }

            }
        };

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        assertThat(intWrapper.get(), is(1_000_000));

        System.out.println(intWrapper.get());
    }

    @Test
    public void test4() throws Exception {
        IntWrapper intWrapper = new IntWrapper();

        Object lock = new Object();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    synchronized (lock) {
                        intWrapper.incrementOn(10);
                    }
                }
            }
        };

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        assertThat(intWrapper.get(), is(1_000_000));

        System.out.println(intWrapper.get());
    }
}
