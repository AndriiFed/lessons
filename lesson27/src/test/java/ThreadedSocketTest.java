import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import sun.security.ssl.SSLSocketImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ThreadedSocketTest {
    @Test(timeout = 60000)
    public void testSimpleTcpServer() throws Exception {
        try (ServerSocket socket = new ServerSocket(1331)) {
            while (true) {
                try (Socket connection = socket.accept()) {
                    OutputStream out = connection.getOutputStream();
                    Writer writer = new OutputStreamWriter(out);

                    writer.write("hello" + new Random().nextInt() + "\n");
                    writer.flush();

                    Thread.sleep(10000);

                    writer.write("enough..\n");
                    writer.flush();

                    connection.close();
                }
            }
        }
    }

    @Test
    public void testSimpleThread() throws Exception {
        Thread th1 = new MyThread(1);
        Thread th2 = new MyThread(2);
        Thread th3 = new MyThread(3);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        System.out.println(111);
        th2.join();
        System.out.println(222);
        th3.join();

        System.out.println(th1.getName());
    }

    Object objField = new Object();

    @Test
    public void testRunnable() throws Exception {
        int i = 10;
        Object obj = new Object();
        objField = null;
        int[] ii = {100};

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("i=" + i);
                System.out.println("obj=" + obj);
                System.out.println("objField=" + objField);
                System.out.println("ii=" + ii[0]);
                ii[0] = 200;
                System.out.println("ii=" + ii[0]);
                System.out.println("hello");
            }
        };


        new Thread(runnable).start();
        new Thread(runnable).start();

        Thread.sleep(5000);
    }

    @Test(timeout = 60000)
    public void testMultiThreadedTcpServer() throws Exception {
        class Worker extends Thread {
            private Socket connection;

            public Worker(Socket connection) {
                this.connection = connection;
            }

            @Override
            public void run() {
                try {
                    OutputStream out = connection.getOutputStream();
                    Writer writer = new OutputStreamWriter(out);

                    writer.write("hello" + new Random().nextInt() + "\n");
                    writer.flush();

                    Thread.sleep(10000);

                    writer.write("enough..\n");
                    writer.flush();

                    connection.close();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        try (ServerSocket socket = new ServerSocket(1331)) {
            while (true) {
/*                try (Socket connection = socket.accept()) {
                    new Worker(connection).start();
                }*/

                try {
                    Socket connection = socket.accept();
//                    new Thread(new Worker(connection)).start();
                    new Worker(connection).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Socket connectionField;
    private Runnable workerTask = new Runnable() {
        @Override
        public void run() {
            try {
                final Socket connection = connectionField;
                OutputStream out = connection.getOutputStream();
                Writer writer = new OutputStreamWriter(out);

                writer.write("hello" + new Random().nextInt() + "\n");
                writer.flush();

                Thread.sleep(10000);

                writer.write("enough..\n");
                writer.flush();

                connection.close();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Test(timeout = 60000)
    public void testMultiThreadedTcpServerRunnable() throws Exception {
        try (ServerSocket socket = new ServerSocket(1331)) {
            while (true) {
                connectionField = socket.accept();
                new Thread(workerTask).start();
            }
        }
    }
}
