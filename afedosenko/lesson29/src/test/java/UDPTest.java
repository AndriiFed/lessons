import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UDPTest {
  @Test
  public void UDPClientTest() throws Exception {
    DatagramSocket socket = new DatagramSocket();
    InetAddress localHost = InetAddress.getLocalHost();
    //InetAddress localHost = InetAddress.getByName("192.168.1.111");


    String hello = "Hello from " + InetAddress.getLocalHost();
    DatagramPacket packet = new DatagramPacket(hello.getBytes(), 0, hello.getBytes().length, localHost, 1331);

    socket.send(packet);


    byte[] data = new String("Hello from " + socket.getLocalAddress()).getBytes();
    DatagramPacket request = new DatagramPacket(data, 0, data.length);
    socket.receive(request);

    System.out.format("ECHO from Server %s:%d - %s\r\n",
      request.getAddress(),
      request.getPort(),
      new String(data));



  }

  @Test (timeout = 60000)
  public void UDPServerTest() throws Exception {
   DatagramSocket socket = new DatagramSocket(1331);


    while (true) {
      byte[] data = new String("Hello from " + InetAddress.getLocalHost()).getBytes();
     //byte[] data = byte[32];

      DatagramPacket request = new DatagramPacket(data, 0, data.length);
      socket.receive(request);

      System.out.format("RX from %s:%d - %s\r\n",
        request.getAddress(),
        request.getPort(),
        new String(data));

      DatagramPacket response = new DatagramPacket(data, 0,
        request.getAddress(),
        request.getPort());

      socket.send(response);

    }

  }

  @Test
  public void fixedExecutorTest() throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(2);
    //ExecutorService service = Executors.newScheduledThreadPool(2);

    Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello");

        try{
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    service.submit(task);
    service.submit(task);
    service.submit(task);

    Thread.sleep(10000);

  }

  @Test
  public void singleExecutorTest() throws Exception {
    ExecutorService service = Executors.newSingleThreadExecutor();

    Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello");

        try{
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    service.submit(task);
    service.submit(task);
    service.submit(task);

    Thread.sleep(10000);

  }


  @Test
  public void schExecutorTest() throws Exception {
    ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

    Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello");

        try{
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    service.schedule(task, 5, TimeUnit.SECONDS);
    service.submit(task);
    service.submit(task);
    service.submit(task);

    Thread.sleep(10000);

  }

  @Test
  public void collableExecutorTest() throws Exception {
    ExecutorService service = Executors.newSingleThreadExecutor();

    Callable<String> task = new Callable() {
      @Override
      public String call() throws Exception {
        System.out.println("callable hello");
        Thread.sleep(2000);
        return "Hello future";
      }
    };

    Future<String> future = service.submit(task);
    Future<String> future1 = service.submit(task);
    //Future<String> future2 = service.submit(task);
    //service.submit(task);
    //service.submit(task);
    //Thread.sleep(10000);

    System.out.println(future.get());
    System.out.println(future1.get());
    //System.out.println(future2.get());


  }

}
