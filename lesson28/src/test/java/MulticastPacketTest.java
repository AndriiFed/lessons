import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastPacketTest {
    @Test
    public void serverTest() throws Exception {
        MulticastSocket socket = new MulticastSocket();

        InetAddress groupAddress = InetAddress.getByName("224.0.0.1");

        BufferedReader reader = new BufferedReader(new FileReader("translation.dat"));
        String data = reader.readLine();

        DatagramPacket packet = new DatagramPacket(data.getBytes(), 0, data.length(), groupAddress, 1331);

        socket.joinGroup(groupAddress);

        for (int i = 0; i < 100; i++) {
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

        //socket.leaveGroup(groupAddress);
//        socket.close();



    }
}
