import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class NetworkTest {
    @Test
    public void testSimpleSocket()  {
        try (Socket socket = new Socket()) {
            SocketAddress addr = new InetSocketAddress("time-d.nist.gov", 13);
            socket.connect(addr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadFromSocket() throws Exception {
        Socket socket = new Socket("time-d.nist.gov", 13);

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
    public void testWriteToSocket() throws Exception {
        Socket socket = new Socket("whois.arin.net", 43);

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
        ServerSocket serverSocket = new ServerSocket(1331); // if *nix then > 1024

        while (true) {
            Socket connection = serverSocket.accept();

            Writer writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(new Date().toString());
            writer.write("\n");
            writer.flush();
                    
            connection.close();
        }
    }

    @Test
    public void testAdvancedServer() {
        try (ServerSocket serverSocket = new ServerSocket(1331)) {
            while (true) {
                try (Socket connection = serverSocket.accept()) {
                    Writer writer = new OutputStreamWriter(connection.getOutputStream());
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));

                    String command;
                    while ((command = reader.readLine()) != null) {
                        if (command.equalsIgnoreCase("quit")) {
                            writer.write("Bye-bye");
                            writer.flush();
                            break;
                        } else if (command.equalsIgnoreCase("date")) {
                            writer.write(LocalDate.now().toString());
                        } else if (command.equalsIgnoreCase("time")) {
                            writer.write(LocalTime.now().toString());
                        } else if (command.equalsIgnoreCase("datetime")) {
                            writer.write(LocalDateTime.now().toString());
                        } else {
                            writer.write("Unknown command");
                        }
                        writer.write("\r\n");
                        writer.flush();
                    }
                    connection.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
