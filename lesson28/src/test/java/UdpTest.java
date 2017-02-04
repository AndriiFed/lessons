import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class UdpTest {
    @Test
    public void testClient() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress localHost = InetAddress.getLocalHost();

        String hello = "hello";
        DatagramPacket packet = new DatagramPacket(hello.getBytes(), 0, hello.length(), localHost, 1331);

        socket.send(packet);

        byte[] serverResponseData = new byte[32];
        DatagramPacket serverResponse = new DatagramPacket(serverResponseData, serverResponseData.length);

        socket.receive(serverResponse);

        System.out.println(new String(serverResponseData));
    }

    @Test (timeout = 60000)
    public void testServer() throws Exception {
        DatagramSocket socket = new DatagramSocket(1331);

        byte[] data = new byte[32];
        DatagramPacket request = new DatagramPacket(data, 0, data.length);

        while (true) {
            socket.receive(request);

            System.out.format("Received from %s:%d; Message:\"%s\"\n",
                    request.getAddress(),
                    request.getPort(),
                    new String(data)
            );

            DatagramPacket response = new DatagramPacket("123".getBytes(), 3, request.getAddress(), request.getPort());
            socket.send(response);
        }
    }

}
