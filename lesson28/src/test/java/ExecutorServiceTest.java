import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
    @Test
    public void fixedThreadedPool() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        service.submit(task);
        service.submit(task);
        service.submit(task);

        Thread.sleep(10_000);


    }

    @Test
    public void singleThreadedPool() throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        service.submit(task);
        service.submit(task);
        service.submit(task);

        Thread.sleep(10_000);


    }

    @Test
    public void scheduledThreadedPool() throws Exception {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        service.schedule(task, 1, TimeUnit.SECONDS);

        Thread.sleep(10_000);


    }

    @Test
    public void testCallable() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Callable<String> task = new Callable() {
            public String call() {
                System.out.println("hello");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello future";
            }
        };

        Future<String> future = service.submit(task);
        Future<String> future2 = service.submit(task);

        System.out.println(future.get());
        System.out.println(future2.get());

    }
}
