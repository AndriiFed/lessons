import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StreamTest {
    @Test
    public void bufferedInputStream() throws Exception {
        File file = new File("chaos.txt");

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        //InputStream inputStream = new FileInputStream(file);

        int data ;
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
        while ((out = reader.readLine()) != null) {
            System.out.println(out);
        }

        reader.close();
    }

    @Test
    public void byteArrayInputStream() throws Exception {
        String text = "Hello";
        //String text = "Привет";

        InputStream inputStream = new ByteArrayInputStream(text.getBytes());
        int data;
        int chCount = -1;
        do {
            data = inputStream.read();
            chCount++;
        } while (data != -1);

        inputStream.close();

        assertThat(chCount, is(text.length()));
    }

    @Test
    public void charArrayReader() throws Exception {
        //String text = "Hello";
        String text = "Привет";

        Reader reader = new CharArrayReader(text.toCharArray());
        int data;
        int chCount = -1;
        do {
            data = reader.read();
            chCount++;
        } while (data != -1);

        reader.close();

        assertThat(chCount, is(text.length()));
    }

    @Test
    public void outputFileStream() throws Exception {
        String text = "Dearest creature in creation,\n" +
                "Study English pronunciation.\n" +
                "I will teach you in my verse\n" +
                "Sounds like corpse, corps, horse, and worse.\n" +
                "I will keep you, Suzy, busy,\n" +
                "Make your head with heat grow dizzy.\n" +
                "Tear in eye, your dress will tear.\n" +
                "So shall I! Oh hear my prayer.";

        OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream("chaos_shortened.txt"));

        outputStream.write(text.getBytes());

        outputStream.close();
    }

    @Test
    public void fileWriter() throws Exception {
        String text = "Dearest creature in creation,\n" +
                "Study English pronunciation.\n" +
                "I will teach you in my verse\n" +
                "Sounds like corpse, corps, horse, and worse.\n" +
                "I will keep you, Suzy, busy,\n" +
                "Make your head with heat grow dizzy.\n" +
                "Tear in eye, your dress will tear.\n" +
                "So shall I! Oh hear my prayer.";

        Writer writer = new BufferedWriter(
                new FileWriter("chaos_shortened.txt"));

        writer.write(text.toCharArray());

        writer.close();
    }

    @Test
    public void printStreamTest() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);

        printStream.println(10);
        printStream.println("Ten");

        printStream.close();

        String str = new String(out.toByteArray());

        //assertThat(str, is("10\nTen\n"));
    }

    @Test
    public void systemOut() throws Exception {
        OutputStream out = new FileOutputStream("system.out");
        PrintStream printStream = new PrintStream(out);

        System.setOut(printStream);

        System.out.println("Hello system.out");
    }

    @Test
    public void systemIn() throws Exception {
        Scanner scanner = new Scanner(System.in);

        scanner.next();
    }

    @Test
    public void exceptionDemo() throws IOException {
        String text = "Dearest creature in creation,\n" +
                "Study English pronunciation.\n" +
                "I will teach you in my verse\n" +
                "Sounds like corpse, corps, horse, and worse.\n" +
                "I will keep you, Suzy, busy,\n" +
                "Make your head with heat grow dizzy.\n" +
                "Tear in eye, your dress will tear.\n" +
                "So shall I! Oh hear my prayer.";

        Writer writer = null;
        try {
            writer = new BufferedWriter(
                    new FileWriter("chaos_shortened.txt", true));

            writer.write(text.toCharArray());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    @Test
    public void tryWithResourcesDemo() throws IOException {
        String text = "Dearest creature in creation,\n" +
                "Study English pronunciation.\n" +
                "I will teach you in my verse\n" +
                "Sounds like corpse, corps, horse, and worse.\n" +
                "I will keep you, Suzy, busy,\n" +
                "Make your head with heat grow dizzy.\n" +
                "Tear in eye, your dress will tear.\n" +
                "So shall I! Oh hear my prayer.";

        try (Writer writer = new BufferedWriter(
                new FileWriter("chaos_shortened.txt"))) {
            writer.write(text.toCharArray());
        }
    }

    @Test
    public void tryWithMultipleResourcesDemo() throws IOException {
        String text = "Dearest creature in creation,\n" +
                "Study English pronunciation.\n" +
                "I will teach you in my verse\n" +
                "Sounds like corpse, corps, horse, and worse.\n" +
                "I will keep you, Suzy, busy,\n" +
                "Make your head with heat grow dizzy.\n" +
                "Tear in eye, your dress will tear.\n" +
                "So shall I! Oh hear my prayer.";

        try (FileWriter fileWriter = new FileWriter("chaos_shortened.txt");
             Writer writer = new BufferedWriter(fileWriter);)
        {
            writer.write(text.toCharArray());
        }
    }
}
