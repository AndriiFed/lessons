import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.RunnableFuture;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class NetworkTest {

  @Test (timeout = 60000)
  public void testSimpleTcpServerSocket() throws Exception {
    class Worker extends Thread {
      private Socket connection;

      public Worker(Socket connection) {
        this.connection = connection;
      }

      @Override
      public void run() {
        try {
          Writer writer = new OutputStreamWriter(connection.getOutputStream());
          writer.write("Hello Single Connection! " + new Random().nextInt() + "\r\n");
          writer.flush();

          Thread.sleep(10000);

          writer.write("enough...\r\n");
          writer.flush();
          connection.close();
        } catch (IOException | InterruptedException e) {
          throw new RuntimeException(e);
        }

      }
    }


    try (ServerSocket serverSocket = new ServerSocket(1331)) { // if *nix then > 1024

      while (true) {
        try {
          Socket connection = serverSocket.accept();
          // new Thread(new Worker(connection)).start(); // method 1
          new Worker(connection).start(); // method 2
        } catch (IOException e) {
          e.printStackTrace();
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
    System.out.println(333);

    System.out.println(th1.getName());
    System.out.println(th2.getName());
    System.out.println(th3.getName());
    //Thread.sleep(10000); // sleep() => EVIL

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
        System.out.println("i = " + i);
        System.out.println("ii = " + ii[0]);
        ii[0] = 200;
        System.out.println("ii = " + ii[0]);
        System.out.println("obj = " + obj);
        System.out.println("objField = " + objField);
        System.out.println("Thread runnable");
      }
    };

    new Thread(runnable).start();
    new Thread(runnable).start();
    Thread.sleep(2000);
  }




}


