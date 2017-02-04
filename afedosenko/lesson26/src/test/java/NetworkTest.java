import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class NetworkTest {
  @Test
  public void testSocket() {

    try (Socket socket = new Socket()) {
      SocketAddress asddr = new InetSocketAddress("time-d.nist.gov", 13);
      socket.connect(asddr);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testSocket2() throws Exception{
    Socket socket = new Socket("time-d.nist.gov", 13);
    socket.setSoTimeout(10000);
    InputStream in = socket.getInputStream();
    InputStreamReader reader = new InputStreamReader(in);

    String response = "";
    int ch = 0;

    while ((ch = reader.read()) != -1) {
      response += (char) ch;
    }
    System.out.println(response);
  }

  @Test (timeout = 5000)
  public void testWhois() throws Exception {
    Socket socket = new Socket("whois.arin.net", 43);
    //socket.setSoTimeout(5000);

    OutputStream out = socket.getOutputStream();
    Writer writer = new OutputStreamWriter(out);

    writer.write("n 127.0.0.1");
    writer.write("\r\n");
    writer.flush();

    InputStream in = socket.getInputStream();
    InputStreamReader reader = new InputStreamReader(in);

    String response = "";
    int ch = 0;

    while ((ch = reader.read()) != -1) {
      response += (char) ch;
    }
    System.out.println(response);

  }

  @Test (timeout = 20000)
  public void testServerSocket() throws Exception {
    ServerSocket serverSocket = new ServerSocket(1331);

    while (true) {
      Socket connection = serverSocket.accept();

      Writer writer = new OutputStreamWriter(connection.getOutputStream());
      writer.write(new Date().toString());
      writer.write("\r\n");
      writer.flush();
      connection.close();
    }

  }


  @Test (timeout = 30000)
  public void testAdvancedServer() throws Exception {

    try (ServerSocket serverSocket = new ServerSocket(1331)) {

      while (true) {
        try (Socket connection = serverSocket.accept()) {

          Writer writer = new OutputStreamWriter(connection.getOutputStream());
          writer.write("HELLO");
          writer.write("\r\n");
          writer.flush();

          while (true) {
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String response;
            response = reader.readLine();
            System.out.println(response);

            switch (response) {
              case "quit":
                writer.write("Bye-bye");
                writer.write("\r\n");
                writer.flush();
                connection.close();
                break;
              case "time":
                writer.write(LocalTime.now().toString());
                writer.write("\r\n");
                writer.flush();
                break;
              case "date":
                writer.write(LocalDate.now().toString());
                writer.write("\r\n");
                writer.flush();
                break;
              case "datetime":
                writer.write(LocalDate.now().toString() + " " + LocalTime.now().toString());
                writer.write("\r\n");
                writer.flush();
                break;
              default:
                writer.write("WRONG");
                writer.write("\r\n");
                writer.flush();
            }
            if (response.equalsIgnoreCase("quit")) {
              break;
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }



}
