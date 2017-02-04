import org.junit.Test;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastPacketTest {

  @Test
  public void serverTest() throws Exception {
    MulticastSocket socket = new MulticastSocket();
    InetAddress groupAddress = InetAddress.getByName("224.0.0.1");

    String hello = "hello";
    DatagramPacket packet = new DatagramPacket(hello.getBytes(), 0, hello.length(), groupAddress, 1313);

    socket.joinGroup(groupAddress);
  for (int i = 0; i < 10; i++) {

    socket.send(packet);
    Thread.sleep(2000);
  }

   socket.leaveGroup(groupAddress);
  }

  @Test
  public void clientTest() throws Exception {
    MulticastSocket socket = new MulticastSocket(1331);

    InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
    socket.joinGroup(groupAddress);

    while (true) {
      byte[] data = new byte[32];
      DatagramPacket packet = new DatagramPacket(data, data.length);
      socket.receive(packet);

      System.out.println(new String(data));

    }

    /*socket.leaveGroup(groupAddress);
    socket.close();*/

  }
}
