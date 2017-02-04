import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import java.io.*;
import java.nio.channels.Channels;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StreamTest {

  @Test
  public void bufferedInput() throws Exception {

    File file = new File("chaos.txt");

    InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
    //InputStream inputStream = new FileInputStream(file);  // DP Decorator

    int data = inputStream.read();
    System.out.println((char)data);

    while ((data = inputStream.read()) != -1) {
      System.out.print((char)data);
    }

    inputStream.close();
  }

  @Test
  public void bufferedReader() throws Exception {
    File file = new File("chaos.txt");

    BufferedReader reader = new BufferedReader(new FileReader(file));

    String out;
    //out =  reader.readLine();
    //System.out.println(out);

    while ((out = reader.readLine()) != null) {
      System.out.println(out);
    }

    reader.close();
  }

  @Test
  public void byteArrayInputStream() throws Exception {
    String text = "Hello";

    InputStream inputStream = new ByteArrayInputStream(text.getBytes());
    int data;
    int charCount = -1;
    do {
      data = inputStream.read();
      charCount++;
      System.out.print((char)data);
    } while (data != -1);

    inputStream.close();
    //assertThat(charCount, is(6));

  }

  @Test
  public void charArrayReader() throws Exception {
    String text = "Hello";

    Reader inputStream = new CharArrayReader(text.toCharArray());
    int data;
    int charCount = -1;
    do {
      data = inputStream.read();
      charCount++;
      //System.out.print((char)data);
    } while (data != -1);

    inputStream.close();

    //assertThat(charCount, is(6));

  }

  @Test
  public void outputFileStream() throws Exception {

    String text = "sal;asdlk\n" +
                  "adkas;dk;akd;aksd;s";

    OutputStream outputStream = new FileOutputStream("my_chaos.txt");
    outputStream.write(text.getBytes());

    outputStream.flush();
    outputStream.close();

  }


  @Test
  public void outputWriterStream() throws Exception {

    String text = "Writer sal;asdlk\n" +
      "adkas;dk;akd;aksd;s";

    Writer writer;
    writer = new BufferedWriter(new FileWriter("my_chaos.txt"));
    writer.write(text.toCharArray());
    writer.close();

  }

  @Test
  public void printStream() throws Exception {
    OutputStream out = new FileOutputStream("system.out");
    PrintStream printStream = new PrintStream(out);

    printStream.println(10);
    printStream.println("Ten");

    System.setOut(printStream);
    System.out.println("Hello system.out");

    printStream.close();

  }

  @Test
  public void systemIn() throws Exception {
    Scanner scanner = new Scanner(System.in);

    //scanner.next();
  }





}
